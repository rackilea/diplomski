package nl.testing.startingpoint;

public class Main {
    private static String paidInFull;

    public static void main(String args[])
    {
        setPaidInFull(true);
        System.out.println(paidInFull);
    }

    public static void setPaidInFull(boolean paidInFull) {
        Main.paidInFull = (paidInFull) ? "Y" : "N";
    }
}