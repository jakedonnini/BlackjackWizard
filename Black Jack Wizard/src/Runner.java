//import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {

        // Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BlackJack Wizard! How many Decks are you playing with?");

        // creates window
        new GUI();

        // input num of decks
        Counter c1 = new Counter();

        GUI.enterDeck(c1);

        System.out.println(
                "Let's begin: \nEnter each card that comes out of the deck and enter \"n\" for new hand. Put \"m\" after card for your card and put \"d\" after for dealer's (ex: 7m, j, kd)... \n\t\t\tGood Luck\n");

        /*
         * Running in the terminal
         * 
         * // runs through max number of cards for for (int i = 0; i < c1.getCardNum() +
         * 10; i++) {
         * 
         * // scan for card c1.addCard(scan.nextLine());
         * 
         * // print the countes System.out.print("Running count: " +
         * c1.getRunningCount()); System.out.print("\tTrue count: " +
         * c1.getTrueCount()); System.out.print("\t " + c1.HowAmIDoing());
         * System.out.print(" Cards used: " + c1.getCurrentCardCount() + " Decks left: "
         * + c1.getCardNum()); System.out.print(c1.showHand());
         * System.out.println(" \u001B[31m" + c1.illust18() + "\u001B[0m"); }
         * 
         */

        // scan.close();
        // System.out.println("Thanks for playing! If you or a loved one has a gabbling
        // addiction call: 1-800-522-4700");
    }
}
