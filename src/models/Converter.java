package models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Converter {
    private String baseCode;
    private String targetCode;

    public void showMenu(){
        System.out.println("""
                    ****************************************
                    Seja bem-vindo(a) ao conversor de moedas!
                                          
                    1) Dólar -> Peso Argentino
                    2) Peso Argentino -> Dólar
                    3) Dólar -> Real Brasileiro
                    4) Real Brasileiro -> Dolar
                    5) Dólar -> Peso Colombiano
                    6) Peso Colombiano -> Dólar
                    7) Sair
                                            
                    Escolha uma opção válida:
                    """);
    }

    public String convertCurrency(double value, int option){
        try {
            switch (option){
            case 1:
                this.baseCode = "USD";
                this.targetCode = "ARS";
                break;
            case 2:
                this.baseCode = "ARS";
                this.targetCode = "USD";
                break;
            case 3:
                this.baseCode = "USD";
                this.targetCode = "BRL";
                break;
            case 4:
                this.baseCode = "BRL";
                this.targetCode = "USD";
                break;
            case 5:
                this.baseCode = "USD";
                this.targetCode = "COP";
                break;
            case 6:
                this.baseCode = "COP";
                this.targetCode = "USD";
                break;
        }

            String apiKey = "6b04a4b029d7c1a522deab04";
            URI link = URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey + "/pair/" + baseCode + "/" + targetCode);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(link)
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);

            return String.format("%.2f %s = %.2f %s", value, baseCode, value * exchangeRateResponse.conversion_rate(),targetCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
