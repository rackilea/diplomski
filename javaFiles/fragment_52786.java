public static void main(String... args) {
        final int c = 100;
        for (int a = 1; a < 37; a++) {
            System.out.println("calculate a:[" + a + "] for c:[" + c + "]. Result: [" + String.format("%.2f", calculate(a, c)) + "]");
        }
    }