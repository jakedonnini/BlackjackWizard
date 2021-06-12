public class StringToInt {

    // private static String input;

    public StringToInt() {

    }

    /** a static method to convert cards in string form to ints */
    public static int toInt(String x) {
        if (x.equals("2")) {
            return 2;
        } else if (x.equals("1")) {
            return 1;
        } else if (x.equals("3")) {
            return 3;
        } else if (x.equals("4")) {
            return 4;
        } else if (x.equals("5")) {
            return 5;
        } else if (x.equals("6")) {
            return 6;
        } else if (x.equals("7")) {
            return 7;
        } else if (x.equals("8")) {
            return 8;
        } else if (x.equals("9")) {
            return 9;
        } else if (x.equals("10")) {
            return 10;
        } else if (x.equals("a")) {
            System.out.println("this will prob cause an error");
            return 11;
        }

        return -1;
    }
}
