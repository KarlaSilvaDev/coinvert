package models;

import com.google.gson.Gson;
import exceptions.ExchangeRateAPIException;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;


public class Converter {
    private final HttpClient httpClient;
    private final Gson gson;
    private final String apiKey;

    public Converter() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.apiKey = Dotenv.load().get("API_KEY");
    }

    private HttpResponse<String> sendRequest(String url) throws IOException, InterruptedException {
        URI link = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();
        return this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public Map<String, String> getSupportedCodes() throws IOException, InterruptedException {
        String API_BASE_URL = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/codes";
        HttpResponse<String> response = sendRequest(API_BASE_URL);
        return this.gson.fromJson(response.body(), ExchangeRateResponse.class).supported_codes();
    }

    private double getConversionRate(String baseCode, String targetCode){
        try {
            String API_BASE_URL = "https://v6.exchangerate-api.com/v6/"+ this.apiKey + "/pair/" + baseCode + "/" + targetCode;
            HttpResponse<String> response = sendRequest(API_BASE_URL);

            if (response.body().contains("\"error-type\":\"invalid-key\"")){
                throw new ExchangeRateAPIException("Chave de API (API Key) inválida.");
            }

            if (response.body().contains("\"error-type\":\"quota-reached\"")){
                throw new ExchangeRateAPIException("Número de requisições máximas do plano atingido.");
            }

            if (response.body().contains("\"error-type\":\"inactive-account\"")){
                throw new ExchangeRateAPIException("Conta inativa.");
            }

            Gson gson = new Gson();
            return gson.fromJson(response.body(), ExchangeRateResponse.class).conversion_rate();

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao acessar a API Exchange Rate: " + e.getMessage());
            return -1;
        } catch (ExchangeRateAPIException e){
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        }
    }

    public String readAndValidateCurrencyCode(String message) throws IOException, InterruptedException {
        Map<String, String> supportedCurrencyCodes = this.getSupportedCodes();
        Scanner scanner = new Scanner(System.in);
        String currencyCode;

        while(true){
            System.out.println(message);
            currencyCode = scanner.next();

            if(supportedCurrencyCodes.containsKey(currencyCode)){
                break;
            }

            System.out.println("Código de moeda informado é inválido ou não é suportado pela API. Tente novamente.");
        }

        return currencyCode ;
    }

    public String convertCurrency(double value, String baseCode, String targetCode ){
        double conversionRate = this.getConversionRate(baseCode, targetCode);
        return String.format("""
                                --------------------------
                                        RESULTADO
                                --------------------------
                                Valor informado: %.2f %s;
                                Taxa de conversão: %.4f;
                                Resultado: %.2f %s
                                --------------------------
                                %n"""
                , value, baseCode, conversionRate, value*conversionRate,targetCode);
    }
}
