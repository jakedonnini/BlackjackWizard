public class Counter {

    private int deckNum;
    private int startingDeckNum;
    private static int runningCount;
    private static int cardsUsed = -1;
    private int youHand;
    private int theirHand;
    private int cardsUsedRound;
    private boolean aceFlag = false;
    private int doubleCheck[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private boolean doubleFound = false;
    private int checkDone;

    // private String red = "\u001B[31m";
    // private String redStop = "\u001B[0m";

    // table of what to do and when
    private String[][] stratTable = {
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand" },
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Hit", "Hit", "Surrender/Hit", "Surrender/Hit",
                    "Surrender/Hit" },
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Hit", "Hit", "Hit", "Surrender/Hit", "Hit" },
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Stand", "Stand", "Stand", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Double" },
            { "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Hit", "Hit" },
            { "Hit", "Hit", "Double", "Double", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit", "Hit" } };

    // Soft totals
    private String[][] aceStratTable = {
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand" },
            { "Stand", "Stand", "Stand", "Stand", "Double", "Stand", "Stand", "Stand", "Stand", "Stand" },
            { "Double", "Double", "Double", "Double", "Double", "Stand", "Stand", "Hit", "Hit", "Hit" },
            { "Hit", "Double", "Double", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Double", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Double", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Double", "Double", "Hit", "Hit", "Hit", "Hit", "Hit" } };

    private String[][] splitStratTable = {
            { "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split" },
            { "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand", "Stand" },
            { "Split", "Split", "Split", "Split", "Split", "Stand", "Split", "Split", "Stand", "Stand" },
            { "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split", "Split" },
            { "Split", "Split", "Split", "Split", "Split", "Split", "Hit", "Hit", "Hit", "Hit" },
            { "Split", "Split", "Split", "Split", "Split", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Double", "Hit", "Hit" },
            { "Hit", "Hit", "Hit", "Split", "Split", "Hit", "Hit", "Hit", "Hit", "Hit" },
            { "Split", "Split", "Split", "Split", "Split", "Split", "Hit", "Hit", "Hit", "Hit" },
            { "Split", "Split", "Split", "Split", "Split", "Split", "Hit", "Hit", "Hit", "Hit" } };

    public Counter(int numOfDecks) {
        deckNum = numOfDecks + 1;
        startingDeckNum = numOfDecks;
    }

    public Counter() {

    }

    /** set the number of decks */
    public void setDeck(String numOfDecks) {
        int x = 0;

        // convert strings to ints
        x = StringToInt.toInt(numOfDecks);

        deckNum = x + 1;
        startingDeckNum = x;
    }

    /**
     * Returns the running count of current game
     * 
     * @return
     */
    public int getRunningCount() {
        return runningCount;
    }

    /** set running count */
    public static void setRunningCount(int x) {
        runningCount = x;
    }

    /**
     * Returns the true count of the current decks
     * 
     * @return ture count in int
     */
    public double getTrueCount() {

        if (deckNum > 0) {
            return runningCount / (deckNum * 1.0);
        }
        // System.out.println("Uh-Oh the deck number hit zreo, you got a bug dumbass!");
        return runningCount / 1.0;
    }

    /**
     * Returns total number of cards in play
     * 
     * @return the number of cards
     */
    public int getCardNum() {
        return startingDeckNum * 52;
    }

    /** returns total used cards */
    public int getCurrentCardCount() {
        return cardsUsed;
    }

    public int getDecksLeft() {
        return deckNum;
    }

    // ** Clears stored hand values */
    public void newHand() {
        youHand = 0;
        theirHand = 0;
        cardsUsedRound = 0;
        aceFlag = false;
        doubleFound = false;
        checkDone = 0;

        for (int i = 0; i < 10; i++) {
            doubleCheck[i] = 0;
        }
    }

    // **returns current hands */
    public String showHand() {
        return " Your hand: " + youHand + " Dealer: " + theirHand;
    }

    public int getYourHand() {
        return youHand;
    }

    public int getTheirHand() {
        return theirHand;
    }

    /**
     * Add a card to be counted. Can use ints and strings
     * (2,3,4,5,6,7,8,9,10,j,q,k,a) Probably won't uses this
     */
    public void addCard(int x) {
        if (x == 2)
            runningCount++;
        if (x == 3)
            runningCount++;
        if (x == 4)
            runningCount++;
        if (x == 5)
            runningCount++;
        if (x == 6)
            runningCount++;
        // 7-9 dont change the count so I wont add them
        if (x == 10)
            runningCount--;

        cardsUsed++;
    }

    /**
     * Add a card to be counted. Can use ints and strings
     * (2,3,4,5,6,7,8,9,10,j,q,k,a) but with strings
     * 
     * @hidden This also has checks to see if an Ace is entered or there is a double
     *         of cards to see if a split is nessary. it effects many other varibles
     *         in the class
     * 
     * @param x enter the string code to add a card with "m" for player hand and "d"
     *          for the dealer
     */
    public void addCard(String x) {
        x = x.toLowerCase();
        String tag = "";

        if (x.length() > 1)
            tag = x.substring(x.length() - 1);

        if (x.equals("n")) {
            newHand();
            cardsUsed--;
        }

        // this is a really bad way to do this but oh well
        if (x.length() > 1) {

            if (x.substring(0, 1).equals("2")) {
                runningCount++;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 2;
                    doubleCheck[0]++;
                } else if (tag.equals("d")) {
                    theirHand += 2;
                }
            }
            if (x.substring(0, 1).equals("3")) {
                runningCount++;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 3;
                    doubleCheck[1]++;
                } else if (tag.equals("d")) {
                    theirHand += 3;
                }
            }
            if (x.substring(0, 1).equals("4")) {
                runningCount++;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 4;
                    doubleCheck[2]++;
                } else if (tag.equals("d")) {
                    theirHand += 4;
                }
            }
            if (x.substring(0, 1).equals("5")) {
                runningCount++;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 5;
                    doubleCheck[3]++;
                } else if (tag.equals("d")) {
                    theirHand += 5;
                }
            }
            if (x.substring(0, 1).equals("6")) {
                runningCount++;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 6;
                    doubleCheck[4]++;
                } else if (tag.equals("d")) {
                    theirHand += 6;
                }
            }

            // 7-9 dont change the count so I wont add them
            if (x.substring(0, 1).equals("7")) {
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 7;
                    doubleCheck[5]++;
                } else if (tag.equals("d")) {
                    theirHand += 7;
                }
            }
            if (x.substring(0, 1).equals("8")) {
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 8;
                    doubleCheck[6]++;
                } else if (tag.equals("d")) {
                    theirHand += 8;
                }
            }
            if (x.substring(0, 1).equals("9")) {
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 9;
                    doubleCheck[7]++;
                } else if (tag.equals("d")) {
                    theirHand += 9;
                }
            }

            if (x.substring(0, 1).equals("1")) {
                runningCount--;
                // check if the card is in an important hand if so add it
                if (tag.equals("m")) {
                    youHand += 10;
                    doubleCheck[8]++;
                } else if (tag.equals("d")) {
                    theirHand += 10;
                }
            }
            // faces

            if (x.substring(0, 1).equals("j")) {
                runningCount--;
                if (tag.equals("m")) {
                    youHand += 10;
                    doubleCheck[8]++;
                } else if (tag.equals("d")) {
                    theirHand += 10;
                }
            }
            if (x.substring(0, 1).equals("k")) {
                runningCount--;
                if (tag.equals("m")) {
                    youHand += 10;
                    doubleCheck[8]++;
                } else if (tag.equals("d")) {
                    theirHand += 10;
                }
            }
            if (x.substring(0, 1).equals("q")) {
                runningCount--;
                if (tag.equals("m")) {
                    youHand += 10;
                    doubleCheck[8]++;
                } else if (tag.equals("d")) {
                    theirHand += 10;
                }
            }
            if (x.substring(0, 1).equals("a")) {
                runningCount--;
                if (tag.equals("m")) {
                    doubleCheck[9]++;

                    aceFlag = true;

                    if (youHand <= 10) {
                        youHand += 11;
                    } else {
                        youHand += 1;
                    }
                } else if (tag.equals("d")) {
                    if (theirHand <= 10) {
                        theirHand += 11;
                    } else {
                        theirHand += 1;
                    }
                }
            }
        } else {
            if (x.equals("2")) {
                runningCount++;

            }
            if (x.equals("3")) {
                runningCount++;

            }
            if (x.equals("4")) {
                runningCount++;

            }
            if (x.equals("5")) {
                runningCount++;

            }
            if (x.equals("6")) {
                runningCount++;

            }

            // 7-9 dont change the count so I wont add them
            if (x.equals("7")) {

            }
            if (x.equals("8")) {

            }
            if (x.equals("9")) {

            }
            // 10
            if (x.equals("1")) {
                runningCount--;

            }
            // faces

            if (x.equals("j")) {
                runningCount--;

            }
            if (x.equals("k")) {
                runningCount--;

            }
            if (x.equals("q")) {
                runningCount--;

            }
            if (x.equals("a")) {
                runningCount--;

            }
        }

        // new card added
        cardsUsed++;

        // count up to 3 cards used in hand
        if (tag.equals("m") || tag.equals("d"))
            cardsUsedRound++;

        // check if deck is used up
        if (cardsUsed % 52 == 0) {
            deckNum -= 1;
        }

        if (youHand > 21 || theirHand > 21) {
            newHand();
        }

        // checking for double cards
        for (int i = 0; i < doubleCheck.length; i++) {

            // check to make sure you have entered at least 2 of your cards
            checkDone += doubleCheck[i];

            if (doubleCheck[i] == 2) {
                doubleFound = true;
                break;
            }

            if (doubleCheck[i] > 3) {
                for (int ii = 0; ii < doubleCheck.length; ii++) {
                    doubleCheck[ii] = 0;
                }
            }
        }
    }

    // **this returns the cards used in each rounds and resets at the end of the
    // round */
    public int getCardsUsed() {
        return cardsUsedRound;
    }

    /** allows you to manually set aceFlag */
    public void setAceFlag(boolean x) {
        aceFlag = x;
    }

    /** returns reading from basic stratagy tables */
    public String basicStrat(int yh, int th) {

        if (cardsUsedRound < 4) {
            if (youHand == 21) {
                return "blackjack!";
            }
            if (aceFlag && checkDone > 2 && !doubleFound) {

                if (yh >= 11) {
                    yh -= 11;
                }

                if (yh > 3)
                    yh = (9 - yh);

                if (th > 0) {
                    th -= 2;
                }
                // System.out.println(yh + " " + th);
                System.out.println("flag");
                return aceStratTable[yh][th];
            } else if (doubleFound && checkDone > 2) {

                yh /= 2;

                if (aceFlag) {
                    yh = 0;
                } else if (yh > 1)
                    yh = (11 - yh);

                if (th > 0) {
                    th -= 2;
                }

                // System.out.println(yh + " " + th);

                return splitStratTable[yh][th];
            } else if (checkDone > 2) {

                // move yh to readable num for array
                if (yh >= 17) {
                    yh = 0;
                } else if (yh > 3) {
                    yh = (17 - yh);
                }

                // move th to readable num for array
                if (th > 0) {
                    th -= 2;
                }

                // System.out.println(yh + " " + th);
                return stratTable[yh][th];
            }
        }

        return "";
    }

    /** add one to the numebr of cards used */
    public void addCardUsed() {
        cardsUsedRound++;
    }

    public String HowAmIDoing() {

        String advice = "";

        if (getTrueCount() >= 4) {
            advice += "You're very likely to get large cards! You should take insurance.";
            /*
             * if (theirHand < 10 || youHand > 11) { advice += "You should probably " + red
             * + "Stand" + redStop; } else { advice += "You should probably " + red + "Hit"
             * + redStop; }
             */
        } else if (getTrueCount() >= 3) {
            advice += "Bet the Max! You should take insurance.";
        } else if (getTrueCount() >= 1) {
            advice += "Bet above the minimum";
        } else if (getTrueCount() < 1 && getTrueCount() > -1) {
            advice += "You're even, could go either way";
        } else if (getTrueCount() <= -3) {
            advice += "KEEP YOUR HAND OFF THOSE FUCKING CHIPS!";
        } else if (getTrueCount() <= -2) {
            advice += "You're more likely to get small cards. Leave the table.";
        } else if (getTrueCount() <= -1) {
            advice += "bet the minimum. Keep playing";
        }

        // advice += basicStrat(youHand, theirHand);

        return advice;
    }

    public String toString() {
        return "Decks Started with: " + startingDeckNum + "\nCurrent number of decks: " + deckNum + "\nRunning count: "
                + runningCount + "\nTrue count: " + getTrueCount();
    }

    /**
     * easy way to add new devations
     * 
     * @return return what to do
     * 
     * @param yhT    in put the number in the players hand is supposed to be
     * @param thT    in put the number in the dealers hand is supposed to be
     * @param index  what the true count is supposed to be
     * @param doIf   if conditions are met this is what to do
     * @param doElse if the conditions are not met do this instead
     */
    public String deviations(int yhT, int thT, int index, String doIf, String doElse) {

        if (youHand == yhT && theirHand == thT) {
            if (getTrueCount() >= index) {
                return doIf;
            } else {
                return doElse;
            }
            // newHand();
        }

        return "";
    }

    // ** Illustrious 18 are combinations that we know what to do with */
    public String illust18() {

        // 1
        if (youHand == 16 && theirHand == 10) {
            if (getTrueCount() >= 0) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 2
        if (youHand == 15 && theirHand == 10) {
            if (getTrueCount() >= 4) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 3
        if (youHand == 20 && theirHand == 5) {
            if (getTrueCount() >= 5) {
                return "Split if two 10s, other wise ignore.";
            } else {
                return "Stand";
            }
            // newHand();
        }
        // 4
        if (youHand == 20 && theirHand == 6) {
            if (getTrueCount() >= 4) {
                return "Split if two 10s, other wise ignore.";
            } else {
                return "Stand";
            }
            // newHand();
        }
        // 5
        if (youHand == 10 && theirHand == 10) {
            if (getTrueCount() >= 4) {
                return "Double";
            } else {
                return "Stand";
            }
            // newHand();
        }
        // 6
        if (youHand == 12 && theirHand == 3) {
            if (getTrueCount() >= 2) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 7
        if (youHand == 12 && theirHand == 2) {
            if (getTrueCount() >= 3) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 8
        if (youHand == 11 && theirHand == 11) {
            if (getTrueCount() >= 1) {
                return "Double";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 9
        if (youHand == 9 && theirHand == 2) {
            if (getTrueCount() >= 1) {
                return "Double";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 10
        if (youHand == 10 && theirHand == 11) {
            if (getTrueCount() >= 4) {
                return "Double";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 11
        if (youHand == 9 && theirHand == 7) {
            if (getTrueCount() >= 3) {
                return "Double";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 12
        if (youHand == 16 && theirHand == 9) {
            if (getTrueCount() >= 5) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 13
        if (youHand == 13 && theirHand == 2) {
            if (getTrueCount() >= -1) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 14
        if (youHand == 12 && theirHand == 4) {
            if (getTrueCount() >= 0) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 15
        if (youHand == 12 && theirHand == 5) {
            if (getTrueCount() >= -2) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 16
        if (youHand == 12 && theirHand == 6) {
            if (getTrueCount() >= -1) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }
        // 17
        if (youHand == 13 && theirHand == 3) {
            if (getTrueCount() >= -2) {
                return "Stand";
            } else {
                return "Hit";
            }
            // newHand();
        }

        // if met surrender
        if (youHand == 14 && theirHand == 10)
            return deviations(14, 10, 3, "Surrender", "");

        if (youHand == 15 && theirHand == 10)
            return deviations(15, 10, 0, "Surrender", "");

        if (youHand == 15 && theirHand == 9)
            return deviations(15, 9, 2, "Surrender", "");

        if (youHand == 15 && theirHand == 11)
            return deviations(15, 11, 1, "Surrender", "");

        return "";
    }

}
