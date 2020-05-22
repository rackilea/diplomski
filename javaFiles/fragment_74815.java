public class FourByFour {

    private List<String> hexlify(final String plaintext) {
        byte[] x = plaintext.getBytes();
        final List<String> list = new ArrayList<>();
        for (final byte aX : x) {
            int b = (int) aX;
            list.add(Integer.toHexString(b));
        }
        return list;
    }

    private void fourByFour(final List<String> hexString) {
        /*
            1st row is:: 48   6f   72   00
            2nd row is:: 65   20   6c   00
            3rd row is:: 6c   77   64   00
            4th row is:: 6c   6f   00   00
         */
        for (int x = 0; x < 4; x++) {
            for (int y = x; y < hexString.size(); y += 4) {
                System.out.print(hexString.get(y) + " ");
            }
            System.out.println("00");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        final FourByFour fourByFour = new FourByFour();
        final List<String> hexString = fourByFour.hexlify("Hello World");
        fourByFour.fourByFour(hexString);
    }
}