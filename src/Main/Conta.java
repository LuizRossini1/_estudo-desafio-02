package Main;
import Interfaces.Calculation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta implements Calculation {
    //variables
    private String totalPurchases;
    private double cardLimit;
    private double priceProducts;

    //empty contructor
    public Conta(){
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
}