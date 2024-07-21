package Main;
import java.util.Scanner;

public class Main {
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

    public static void main(String[] args) {
        //defining scanner
        Scanner scanner = new Scanner(System.in);

        //objects
        var myAccount = new Main();

        String menu =
                "Welcomete to Alura shop! \n" +
                        "Type your card limit: ";

        System.out.println(menu);
    }

}