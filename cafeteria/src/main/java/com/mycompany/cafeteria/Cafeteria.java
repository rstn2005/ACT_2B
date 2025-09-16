/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cafeteria;
import java.util.*;
/**
 *
 * @author Carlo
 */
public class Cafeteria {
    static class Item {
        String name;
        int price;
        int quantity;

        Item(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        int getSubtotal() {
            return price * quantity;
        }
    }
    
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
        List<Item> cart = new ArrayList<>();

        while (true) {
            System.out.println(""); 
            System.out.println("---My Little Coffee Shop---");
            System.out.println("[1] - COFFEE");
            System.out.println("[2] - PASTRY");
            System.out.println("[3] - CHECKOUT / EXIT");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("---COFFEE---");
                System.out.println("[1] - HOT COFFEE");
                System.out.println("[2] - ICED COFFEE");
                System.out.print("Enter your choice: ");
                int coffee = input.nextInt();

                if (coffee == 1) {
                    System.out.println("---HOT COFFEE---");
                    System.out.println("[1] - Latte (₱135)");
                    System.out.println("[2] - Cappuccino (₱130)");
                    System.out.println("[3] - Americano (₱140)");
                    System.out.print("Enter your Hot Coffee: ");
                    int hot = input.nextInt();

                    if (hot == 1) addItem(cart, "Latte", 135, input);
                    else if (hot == 2) addItem(cart, "Cappuccino", 130, input);
                    else if (hot == 3) addItem(cart, "Americano", 140, input);
                } 
                else if (coffee == 2) {
                    System.out.println("---ICED COFFEE---");
                    System.out.println("[1] - Iced Latte (₱145)");
                    System.out.println("[2] - Iced Mocha (₱150)");
                    System.out.println("[3] - Iced Macchiato (₱160)");
                    System.out.print("Enter your Iced Coffee: ");
                    int iced = input.nextInt();

                    if (iced == 1) addItem(cart, "Iced Latte", 145, input);
                    else if (iced == 2) addItem(cart, "Iced Mocha", 150, input);
                    else if (iced == 3) addItem(cart, "Iced Macchiato", 160, input);
                }
            } 
            else if (choice == 2) {
                System.out.println("---PASTRY---");
                System.out.println("[1] - Cookies (₱125)");
                System.out.println("[2] - Croissants (₱135)");
                System.out.println("[3] - Donut (₱130)");
                System.out.print("Enter your choice: ");
                int pastry = input.nextInt();

                if (pastry == 1) addItem(cart, "Cookies", 125, input);
                else if (pastry == 2) addItem(cart, "Croissants", 135, input);
                else if (pastry == 3) addItem(cart, "Donut", 130, input);
            } 
            else if (choice == 3) {
                if (cart.isEmpty()) {
                    System.out.println("No items purchased. Thank you for visiting!");
                } else {
                    printReceipt(cart, input);
                }
                break;
            }
        }
        input.close();
    }

    // Add item to cart
    private static void addItem(List<Item> cart, String name, int price, Scanner input) {
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        cart.add(new Item(name, price, quantity));
        System.out.println(quantity + " x " + name + " added to cart.");
    }

    // Print final receipt
    private static void printReceipt(List<Item> cart, Scanner input) {
        System.out.println("\n========= RECEIPT =========");
        int subtotal = 0;
        for (Item item : cart) {
            int lineTotal = item.getSubtotal();
            subtotal += lineTotal;
            System.out.printf("%-15s x%d   ₱%d\n", item.name, item.quantity, lineTotal);
        }

        double vat = subtotal * 0.12;
        double total = subtotal + vat;

        System.out.println("---------------------------");
        System.out.printf("Subtotal:        ₱%.2f\n", (double) subtotal);
        System.out.printf("VAT (12%%):       ₱%.2f\n", vat);
        System.out.printf("TOTAL:           ₱%.2f\n", total);

        System.out.print("Enter your cash: ");
        double cash = input.nextDouble();
        while (cash < total) {
            System.out.print("Not enough cash. Enter again: ");
            cash = input.nextDouble();
        }

        double change = cash - total;
        System.out.printf("CASH:            ₱%.2f\n", cash);
        System.out.printf("CHANGE:          ₱%.2f\n", change);
        System.out.println("===========================");
        System.out.println("Thank you for visiting My Little Coffee Shop!");
        }
}

    
