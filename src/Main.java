import exceptions.ExchangeRateAPIException;
import models.Converter;
import models.CurrencyPair;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        boolean exit = false;


        try {
            while (!exit) {
                int option = 0;

                while (!menuOptions.containsKey(option)) {
                    showMenu();
                    System.out.println("Escolha uma opção: ");
                    option = scanner.nextInt();

                    if (!menuOptions.containsKey(option)){
                        System.out.println("ERRO: Opção inválida.\nTente novamente.");
                    }
                }

                if (option == menuOptions.size()) {
                    exit = true;
                    continue;
                }

                String baseCode = menuOptions.get(option).baseCode();
                String targetCode = menuOptions.get(option).targetCode();

                if (baseCode.isEmpty() && targetCode.isEmpty()) {
                    String answer;

                    while (true){
                        System.out.println("Deseja verificar os códigos de moeda suportados? [S/N]");
                        answer = scanner.next().toLowerCase();

                        if (answer.equals("s") || answer.equals("n")) {
                            break;
                        }

                        System.out.println("ERRO: Resposta inválida. Digite S para Sim e N para Não:");
                    }

                    if (answer.equals("s")){
                        System.out.println(converter.getSupportedCodes());
                    }

                    baseCode = converter.readAndValidateCurrencyCode("Insira o código da moeda base: ");
                    targetCode = converter.readAndValidateCurrencyCode("Insira o código da moeda alvo: ");

                }

                double value = 0;

                while(value <= 0) {
                    System.out.println("Digite o valor a ser convertido: ");
                    value = scanner.nextDouble();

                    if (value <= 0) {
                        System.out.println("ERRO: Digite um valor maior que zero.");
                    }
                }

                System.out.println(converter.convertCurrency(value, baseCode, targetCode));
            }
        }catch(InputMismatchException e) {
            System.out.println("ERRO: Tipo de entrada inválida. Certifique de informar apenas números.");
        }catch (ExchangeRateAPIException e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("ERRO: Não foi possível acessar a API Exchange Rate");
        } finally {
            System.out.println("Obrigado por utilizar o conversor de moedas. Até mais!");
            scanner.close();
        }
    }

    public static void showMenu(){
        System.out.println("""
                    ****************************************
                    Seja bem-vindo(a) ao conversor de moedas!
                                          
                    1) Dólar -> Peso Argentino
                    2) Peso Argentino -> Dólar
                    3) Dólar -> Real Brasileiro
                    4) Real Brasileiro -> Dolar
                    5) Dólar -> Peso Colombiano
                    6) Peso Colombiano -> Dólar
                    7) Definir outro tipo de conversão
                    8) Sair
                                            
                    ****************************************
                    """);
    }

    private static final Map<Integer, CurrencyPair> menuOptions = new HashMap<>();
    static{
        menuOptions.put(1, new CurrencyPair( "USD", "ARS"));
        menuOptions.put(2, new CurrencyPair("ARS", "USD"));
        menuOptions.put(3, new CurrencyPair("USD", "BRL"));
        menuOptions.put(4, new CurrencyPair("BRL", "USD"));
        menuOptions.put(5, new CurrencyPair("USD", "COP"));
        menuOptions.put(6, new CurrencyPair("COP", "USD"));
        menuOptions.put(7, new CurrencyPair("", ""));
        menuOptions.put(8, new CurrencyPair("", "")); //Exit
    }
}
