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

    //empty constructor
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
    public void creditLimit() {
        Scanner scannerCredit = new Scanner(System.in);

        String menu =
                "Welcomete to Alura shop! \n" +
                        "Type your card limit: ";

        System.out.println(menu);
        cardLimit = scannerCredit.nextDouble();
        System.out.println("Your card limit is: U$" +this.getCardLimit());
    }
    public void purchase() {
        Scanner scannerPurshase = new Scanner(System.in);
        Scanner scannerOption = new Scanner(System.in);
        List<String> productsList = new ArrayList<>();
        List<Double> purshasedPrices = new ArrayList<>();

        System.out.println("Type what you want to buy:");
        productsList.add(scannerPurshase.nextLine());
        System.out.println("Type the price of product:");
        double totalPreco = scannerPurshase.nextDouble();
        this.cardLimit = cardLimit - totalPreco;
        purshasedPrices.add(totalPreco);

        System.out.println("Current credit: " +getCardLimit());

        if (priceProducts > this.getCardLimit()) {
            System.out.println("Insufficient credit!");
            return;
        }

        System.out.println("Type 0 to quit and 1 to continue:");
        int option = 0;
        option = scannerOption.nextInt();
        if (option == 0) {
            System.out.println("Closing app...");
            } else if (option == 1) {
                purchase();
            } else {
                System.out.println("Error! Choice a valid option");
            }

        for (String products : productsList) {
            System.out.println("Products: " +products);
        }

        for (Double prices : purshasedPrices) {
            System.out.println("Products prices: " + prices);
        }
    }

    public static void main(String[] args) {
        //objects
        var myAccount = new Main();

        myAccount.creditLimit();
        myAccount.purchase();
    }
}