//! ATM

import java.util.Scanner;

public class ATM {
    static Scanner scanner = new Scanner(System.in);
    static int balance = 100_000_000;
    static int password = 1234;

    public static void main(String[] args) {
        showMenuLanguage();
    }

    public static void showMenuLanguage() {
        System.out.println("Kirish");
        System.out.println("1. O'zbekcha");
        System.out.println("2. Inglizcha");
        System.out.println("3. Ruscha");

        int language = scanner.nextInt();

        switch (language) {
            case 1:
            case 2:
            case 3:
                askPassword();
                break;
            default:
                System.out.println("Noto'g'ri tanlov. Iltimos qaytadan urinib ko'ring");
                showMenuLanguage();
        }

    }

    public static void askPassword() {
        System.out.println("Plastik kartangizni parolni kiriting:");
        int userPassword = scanner.nextInt();

        if (userPassword == password) {
            System.out.println("Tizimga kirdingiz");
            showMainMenu();
        } else {
            System.out.println("Parol noto'g'ri. Iltimos qaytadan urinib ko'ring");
            askPassword();
        }
    }

    public static void showMainMenu() {
        System.out.println("Bosh menyu");
        System.out.println("1. Balansni tekshirish");
        System.out.println("2. Naqd pul olish");
        System.out.println("3. SMS xabar ulash / o'chirish");
        System.out.println("4. Parolni o'zgartirish");
        System.out.println("5. Mobil aloqa uchun to'lov");
        System.out.println("6. Kredit to'lovlari");
        System.out.println("7. Kamunal to'lovlar");
        System.out.println("8. Dasturdan chiqish");

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawCash();
                break;
            case 3:
                smmSetting();
                break;
            case 4:
                changePassword();
                break;
            case 5:
                mobilePayment();
                break;
            case 6:
                creditPayment();
                break;
            case 7:
                utilityPayment();
                break;
            case 8:
                System.out.println("Dasturdan chiqdingiz");
                System.exit(0);
                break;
            default:
                System.out.println("Noto'g'ri tanlov. Iltimos qaytadan urinib ko'ring");

        }

    }

    public static void checkBalance() {
        System.out.println("Sizning balansingizda " + balance + " so'm bor");
        showMainMenu();
    }

    public static void withdrawCash() {
        System.out.println("Naqd pul olish");
        System.out.println("1. 50 ming");
        System.out.println("2. 100 ming");
        System.out.println("3. 150 ming");
        System.out.println("4. 200 ming");
        System.out.println("5. 300 ming");
        System.out.println("6. 400 ming");
        System.out.println("7. Boshqa summa");
        System.out.println("8. Orqaga");

        int userChoice = scanner.nextInt();
        int amount = 0;
        switch (userChoice) {
            case 1:
                amount = 50_000;
                break;
            case 2:
                amount = 100_000;
                break;
            case 3:
                amount = 150_000;
                break;
            case 4:
                amount = 200_000;
                break;
            case 5:
                amount = 300_000;
                break;
            case 6:
                amount = 400_000;
                break;
            case 7:
                System.out.print("Summa kiriting: ");
                amount = scanner.nextInt();
                break;
            case 8:
                showMainMenu();
                break;
            default:
                System.out.println("Noto'g'ri tanlov.");
                withdrawCash();
                return;

        }

        if (amount > balance) {
            System.out.println("Balansda yetarli mablag' mavjud emas");

        } else {
            balance -= amount;
            System.out.println(amount + "so'm naqd pul olindi.Sizning balansingizda " + balance + " so'm qoldi");
        }
        showMainMenu();
    }

    public static void smmSetting() {
        System.out.print("Telefon raqamingizni kiriting:");
        String phoneNumber = scanner.next();

        System.out.println("SMS xabar ulash/o'chirish");
        System.out.println("1. SMS xabar ulash");
        System.out.println("2. SMS xabar o'chirish");
        System.out.println("3. Orqaga");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                System.out.println("SMS xabar " + phoneNumber + " telefon nomerga yoqildi");
                break;
            case 2:
                System.out.println("SMS xabar " + phoneNumber + " telefon nomerdan o'chirildi");
                break;
            case 3:
                showMainMenu();
                break;
            default:
                System.out.println("Noto'g'ri tanlov.");

        }

        showMainMenu();
    }

    public static void changePassword() {
        System.out.print("Eski parolni kiriting:");
        int oldPassword = scanner.nextInt();
        if (oldPassword == password) {
            System.out.print("Yangi parol kiriting:");
            int newPassword = scanner.nextInt();
            System.out.print("Yangi parolni qayta kiriting:");
            int newPassword2 = scanner.nextInt();
            if (newPassword == newPassword2) {
                password = newPassword;
                System.out.println("Parol muvaffaqiyatli o'zgartirildi");
            } else {
                System.out.println("Parollar mos kelmadi. Iltimos qaytadan urinib ko'ring");
                changePassword();
            }

        } else {
            System.out.println("Parol noto'g'ri. Iltimos qaytadan urinib ko'ring");
            changePassword();
        }

        showMainMenu();
    }

    public static void mobilePayment() {
        System.out.println("Mobil aloqa uchun to'lov");
        System.out.println("1. UzMobile");
        System.out.println("2. Beeline");
        System.out.println("3. Mobiuz");
        System.out.println("4. Ucell");
        System.out.println("5. Orqaga");

        int userChoice = scanner.nextInt();

        if (userChoice == 5) {
            showMainMenu();
        } else {
            System.out.print("Telefon raqamingizni kiriting:");
            String phoneNumber = scanner.next();
            System.out.print("To'lov miqdorini kiriting: ");
            int amount = scanner.nextInt();

            if (amount > balance) {
                System.out.println("Balansda yetarli mablag' mavjud emas");
            } else {
                balance -= amount;
                System.out.println(amount + "so'm " + phoneNumber + " raqamiga to'lov qilindi. Sizning balansingizda "
                        + balance + " so'm qoldi");
            }
            showMainMenu();

        }
    }

    public static void creditPayment() {
        System.out.println("Kredit raqamini kirting: ");
        String creditNumber = scanner.next();
        System.out.println("To'lov miqdorini kiriting:");
        int amount = scanner.nextInt();
        if (amount > balance) {
            System.out.println("Balansda yetarli mablag' mavjud emas");
        } else {
            balance -= amount;
            System.out.println(amount + "so'm " + creditNumber + " raqamiga to'lov qilindi. Sizning balansingizda "
                    + balance + " so'm qoldi");
        }
        showMainMenu();
    }

    public static void utilityPayment() {
        System.out.println("Kamunal tolovlar");
        System.out.println("1. Elektr energiyasi");
        System.out.println("2. Jarimalar");
        System.out.println("3. Gaz");
        System.out.println("4. Suv");
        System.out.println("5. Orqaga");

        int userChoice = scanner.nextInt();
        if (userChoice == 5) {
            showMainMenu();
        } else {
            System.out.print("To'lov miqdorini kiriting:");
            int amount = scanner.nextInt();
            if (amount > balance) {
                System.out.println("Balansda yetarli mablag' mavjud emas");
            } else {
                balance -= amount;
                System.out.println("Kamunal to'lov amalga oshirildi");
            }
            showMainMenu();
        }
    }

}
