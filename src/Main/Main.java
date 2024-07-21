package Main;
import Interfaces.Calculation;

import java.util.Scanner;

public class Main implements Calculation {
    //variables
    private int totalPurchases;
    private double cardLimit;

    //setter
    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    //getters
    public int getTotalPurchases() {
        return totalPurchases;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    Scanner scanner = new Scanner(System.in);


    @Override
    public void creditCalculation() {
        cardLimit = scanner.nextDouble();
    }

    public static void main(String[] args) {
        //defining scanner
        Scanner scanner = new Scanner(System.in);

        //objects
        var myAccount = new Main();

        String menu =
                "Welcomete to Alura shop! \n" +
                        "Type your card limit: ";

        System.out.println(menu);

        myAccount.creditCalculation();
        System.out.println("Your card limit is: U$" +myAccount.getCardLimit());
    }
}