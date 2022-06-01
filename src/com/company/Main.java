package com.company;

import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";     // статичная переменная хранения алфавита

    private static char shiftingSymbolForEncrypt(char shiftSymbol, int key) {                   //метод для сдвига символов
        if (ALPHABET.indexOf(shiftSymbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(shiftSymbol) + key) % ALPHABET.length());
        } else
            return shiftSymbol;
    }

    private static void encryptText(String text, int key) {                                    //метод шифровки текста
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(shiftingSymbolForEncrypt(text.charAt(i), key));
        }
    }
    private static void decryptText(String text, int key) {                                    //метод расшифровки текста
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(shiftingSymbolForEncrypt(text.charAt(i), ALPHABET.length()-(key % ALPHABET.length())));
        }
    }
    private static void bruteForceText(String text){                                           // метод перебора возможных вариантов "брутфорс"
        text.toLowerCase();
        for (int i = 0; i < ALPHABET.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                System.out.print(shiftingSymbolForEncrypt(text.charAt(j),i) );
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует программа шифровки и дешифровки шифром \"Цезаря\"\nВведите код команды:\n1.Зашифровать текст\n2.Расшифровать текст\n3.Расшифровка методом \"брутфорс\"\n0.Выход");
        int command = scanner.nextInt();
        while (command != 0) {
            if (command == 1) {
                scanner.nextLine();
                System.out.println("Введите текст для шифровки:");
                String text = scanner.nextLine();
                System.out.println("Введите ключ шифрования:");
                int key = scanner.nextInt();
                encryptText(text, key);
                break;
            } else if (command == 2) {
                scanner.nextLine();
                System.out.println("Введите зашифрованный текст:");
                String text = scanner.nextLine();
                System.out.println("Введите ключ шифрования:");
                int key = scanner.nextInt();
                decryptText(text,key);
                break;

            } else if (command == 3) {
                scanner.nextLine();
                System.out.println("Введите зашифрованный текст для взлома методом \"брутфорс\":");
                String text = scanner.nextLine();
               bruteForceText(text);

            } else if (command == 0) {
                break;

            } else {
                System.out.println("Команда не распознана! Введите существующий код команды");

            }break;
        }
    }
}
