package Main;
import Interfaces.Calculation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Calculation {
    //variables
    private String totalPurchases;
    private double cardLimit;
    private double priceProducts;

    //empty contructor
    public Main() {
    }

    //getters
    public String getTotalPurchases() {
        return totalPurchases;
    }
    public double getCardLimit() {
        return cardLimit;
    }
    public double getPriceProducts() {
        return priceProducts;
    }

    @Override
    public void creditLimit(Scanner scannerCredit) {
        String menu =
                "Welcomete to Alura shop! \n" +
                        "Type your card limit: ";

        System.out.println(menu);
        cardLimit = scannerCredit.nextDouble();
        System.out.println("Your card limit is: U$" + this.getCardLimit());
    }
    public void purchase(List<String> productsList, List<Double> purshasedPrices) {
        Scanner scannerPurshase = new Scanner(System.in);

        System.out.println("Type what you want to buy:");
        productsList.add(scannerPurshase.nextLine());
        System.out.println("Type the price of product:");
        double totalPreco = scannerPurshase.nextDouble();
        this.cardLimit = cardLimit - totalPreco;
        purshasedPrices.add(totalPreco);
        System.out.println("Current credit: " + getCardLimit());

        if (priceProducts > this.getCardLimit()) {
            System.out.println("Insufficient credit!");
            return;
        }
    }

    public static void main(String[] args) {
        //objects
        Scanner scannerCredit = new Scanner(System.in);
        List<String> productsList = new ArrayList<>();
        List<Double> purshasedPrices = new ArrayList<>();
        var myAccount = new Main();

        myAccount.creditLimit(scannerCredit);

        Scanner scannerOption = new Scanner(System.in);
        int option = 0;
        while (option != 0 || option != 1) {
            System.out.println("Type '0' to quit and '1' to continue:");
            option = scannerOption.nextInt();
            if (option == 0) {
                System.out.println("Clossing the app...");
                break;
            } else if (option == 1) {
                myAccount.purchase(productsList, purshasedPrices);
            } else {
                System.out.println("Error! Type a valid option");
            }
        }

        System.out.println("************************************");
        if (productsList == null) {
            System.out.println("nada comprado");
        } else {
            System.out.println("Products purchased: " + productsList);
        }
        System.out.println("************************************");
    }
}