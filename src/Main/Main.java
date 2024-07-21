package Main;
import java.util.Scanner;

public class Main {
    //variables
    private int totalPurchases;
    private double cardLimit;

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

        System.out.println(myAccount.getCardLimit());
    }
}