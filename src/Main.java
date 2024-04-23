import models.Converter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        int option = 0;

        while(option < 1 || option > 7) {
            converter.showMenu();
            option = scanner.nextInt();
        }

        System.out.println("Digite o valor a ser convertido: ");
        double value = scanner.nextDouble();

        System.out.println(converter.convertCurrency(value, option));
    }
}
