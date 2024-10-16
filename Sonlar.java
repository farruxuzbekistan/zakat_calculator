import java.util.Scanner;

public class Sonlar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sonni kiriting (-999 dan 999 gacha): ");
        int number = scanner.nextInt();

        if (number < -999 || number > 999) {
            System.out.println("Iltimos, -999 dan 999 oralig'ida son kiriting.");
        } else {
            String result = convertToWords(number);
            System.out.println("So'zlar bilan ifodasi: " + result);
        }

        scanner.close();
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "nol";
        }

        String result = "";
        if (number < 0) {
            result = "minus ";
            number = -number;
        }

        result += convertHundreds(number);
        return result.trim();
    }

    private static String convertHundreds(int number) {
        String result = "";

        // 456
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int ones = number % 10;

        if (hundreds > 0) {
            result += getHundredsWord(hundreds) + " ";
        }

        if (tens > 0) {
            result += getTensWord(tens) + " ";
        }

        if (ones > 0) {
            result += getOnesWord(ones);
        }

        return result.trim();
    }

    private static String getHundredsWord(int number) {
        switch (number) {
            case 1:
                return "bir yuz";
            case 2:
                return "ikki yuz";
            case 3:
                return "uch yuz";
            case 4:
                return "to'rt yuz";
            case 5:
                return "besh yuz";
            case 6:
                return "olti yuz";
            case 7:
                return "yetti yuz";
            case 8:
                return "sakkiz yuz";
            case 9:
                return "to'qqiz yuz";
            default:
                return "";
        }
    }

    private static String getTensWord(int number) {
        switch (number) {
            case 1:
                return "o'n";
            case 2:
                return "yigirma";
            case 3:
                return "o'ttiz";
            case 4:
                return "qirq";
            case 5:
                return "ellik";
            case 6:
                return "oltmish";
            case 7:
                return "yetmish";
            case 8:
                return "sakson";
            case 9:
                return "to'qson";
            default:
                return "";
        }
    }

    private static String getOnesWord(int number) {
        switch (number) {
            case 1:
                return "bir";
            case 2:
                return "ikki";
            case 3:
                return "uch";
            case 4:
                return "to'rt";
            case 5:
                return "besh";
            case 6:
                return "olti";
            case 7:
                return "yetti";
            case 8:
                return "sakkiz";
            case 9:
                return "to'qqiz";
            default:
                return "";
        }
    }
}
