package Main;
import Interfaces.Calculation;
import java.util.Scanner;

public class Main implements Calculation {
    //variables
    private int totalPurchases;
    private double cardLimit;

    //empty constructor
    public Main() {
    }

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

    @Override
    public void creditSum() {
        Scanner scanner = new Scanner(System.in);
        cardLimit = scanner.nextDouble();
    }

    @Override
    public void creditCalculation() {
    }

    public void purchase() {
    }

    //purchase menu
    static String menu =
            "Welcomete to Alura shop! \n" +
                    "Type your card limit: ";

    public static void main(String[] args) {
        //objects
        var myAccount = new Main();

        System.out.println(menu);
        myAccount.creditSum();
        System.out.println("Your card limit is: U$" +myAccount.getCardLimit());




    }
}