public class Coin {
    // keep your original code...

    public static void main(String[] args) {
        Coin theCoin = new Coin();
        for (int i=0; i < 20; ++i) {
            theCoin.toss();
        }

        System.out.println("Coin was heads " + theCoin.getHeadCount() + " times.");
        System.out.println("Coin was tails " + theCoin.getTailCount() + " times.");

    }
}