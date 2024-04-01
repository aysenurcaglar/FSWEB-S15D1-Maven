package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("0: Uygulamayı Durdur");
            System.out.println("1: Eleman Ekle");
            System.out.println("2: Eleman Çıkar");
            System.out.print("Seçiminizi yapınız: ");
            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz elemanları giriniz: ");
                    String addItemInput = scanner.nextLine();
                    addItems(addItemInput);
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz elemanları giriniz: ");
                    String removeItemInput = scanner.nextLine();
                    removeItems(removeItemInput);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyiniz.");
                    break;
            }
        } while (choice != 0);
    }

    public static void addItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " eklendi.");
            } else {
                System.out.println(item + " zaten listede bulunuyor.");
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " çıkarıldı.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Listenin Güncel Hali:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
