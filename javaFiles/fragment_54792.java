public class Main {
    public static void main(String[] args) {
        MorseCode m = new MorseCode();
        String encoded = m.encode("Unencoded Text");
        String decoded = m.decode("..- -. . -. -.-. --- -.. . -.. | - . -..- - ");
        System.out.println(encoded);
        System.out.println(decoded);

    }
}