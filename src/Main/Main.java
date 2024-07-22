package Main;
import Interfaces.Calculation;
import java.util.Comparator;
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
    public void purchase(List<String> productsList, List<Double> purshasedPrices, Scanner scannerPurshase) {
        System.out.println("Type what you want to buy:");
        productsList.add(scannerPurshase.next());
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
    public void loopPurchase(Scanner scannerOption, List<String> productsList,
                             List<Double> purshasedPrices, Scanner scannerPurshase) {
        int option = 0;
        while (option != 0 || option != 1) {
            System.out.println("Type '0' to quit and '1' to continue:");
            option = scannerOption.nextInt();
            if (option == 0) {
                System.out.println("Closing app...");
                return;
            } else {
                this.purchase(productsList, purshasedPrices, scannerPurshase);
            }
        }
    }
    public void displayPurchase(List<String> productsList, List<Double> purshasedPrices) {
        System.out.println("************************************");
        if (productsList == null || productsList.isEmpty()) {
            System.out.println("Nothing purchased");
        } else {
            System.out.println("Products purchased:");
            for (int i = 0; i < productsList.size(); i++) {
                System.out.println(productsList.get(i) + " - " +purshasedPrices.get(i));
            }
        }
        System.out.println("************************************");
    }

    public static void main(String[] args) {
        //objects
        Scanner scannerCredit = new Scanner(System.in);
        Scanner scannerPurshase = new Scanner(System.in);
        Scanner scannerOption = new Scanner(System.in);
        List<String> productsList = new ArrayList<>();
        List<Double> purshasedPrices = new ArrayList<>();
        var myAccount = new Main();

        myAccount.creditLimit(scannerCredit);
        myAccount.loopPurchase(scannerOption, productsList, purshasedPrices, scannerPurshase);
        myAccount.displayPurchase(productsList, purshasedPrices);
    }
}