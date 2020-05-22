import java.util.Random;

class Main {
    public static void main(String[] args) {
        String hex16Chars = String.format("%016X", new Random().nextLong());
        System.out.println(hex16Chars + ", len: " + hex16Chars.length());
    }
}