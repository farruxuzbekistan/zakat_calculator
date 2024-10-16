//! Refactoring - changing structure of the code without changing its behavior
//! Extracting methods

//! ZAKAT KALKULATOR

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int min_zakat = 40_000_000;
        System.out.println("**ZAKAT KALKULATOR**");
        System.out.println("Bu yilgi minimal zakat: " + min_zakat + " so'm");

        Scanner scanner = new Scanner(System.in);
        double totalWealth;

        while (true) {
            double cash = getPositiveInput(scanner, "Naqd pulingizni kiriting (so'm): ");
            double savings = getPositiveInput(scanner, "Bankdagi jamg'armangizni kiriting (so'm): ");
            double gold = getPositiveInput(scanner,
                    "Oltin yoki boshqa qimmatbaho narsalarning qiymatini kiriting (so'm): ");

            // Calculating total wealth
            totalWealth = calculateTotalWealth(cash, savings, gold);

            if (totalWealth >= min_zakat) {
                break;
            } else {
                System.out.println("Sizda zakot hali nisobga yetmagan");
            }

        }

        double zakat = calculateZakat(totalWealth);

        // Display the results
        System.out.println("\nBoyligingizning umumiy miqdori: " + totalWealth + " so'm");
        System.out.printf("Siz to'lashingiz kerak bo'lgan ZAKOT: %.2f so'm\n", zakat);

        // Closing scanner
        scanner.close();
    }

    public static double calculateZakat(double totalWealth) {
        return totalWealth * 2.5 / 100;
    }

    public static double calculateTotalWealth(double cash, double savings, double gold) {
        return cash + savings + gold;
    }

    public static double getPositiveInput(Scanner scanner, String mesage) {
        double value;
        while (true) {
            System.out.println(mesage);
            value = scanner.nextDouble();
            if (value >= 0) {
                break;
            } else {
                System.out.println("Qiymat musbat son bo'lish kerak");
            }
        }
        return value;
    }

}
