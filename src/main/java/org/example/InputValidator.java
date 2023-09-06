package org.example;
import java.util.Scanner;

public class InputValidator {
    /**
     * Trida pro overeni zda zadany retezec odpovida pozadavkum
     */
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Validace zda bylo zadano varchar ( text nebo cislo )
     * @param prompt vstupni varchar
     * @return vraci varchar
     */
    public String getNeprazdnyRetezec(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim(); // Vymaze mezery
            if (input.isEmpty()) {
                System.out.println("Musite neco napsat");
            }
        } while (input.isEmpty());
        return input;
    }

    public int getNezaporneCislo(String prompt) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Nezadali jste cislo. Zadejte prosim cislo.");
                scanner.next(); // Consume the invalid input
            }
            input = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (input < 0) {
                System.out.println("Zadejte nezaporne cislo a zkuste to znovu.");
            }
        } while (input < 0);
        return input;
    }
}

