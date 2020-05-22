public static void main(String[] args) {

    String hexString = "55";

    int value = Integer.parseInt(hexString, 16);

    int numOfBits = 8;

    boolean[] booleans = new boolean[numOfBits];

    for (int i = 0; i < numOfBits; i++) {
        booleans[i] = (value & 1 << i) != 0;
    }

    System.out.println(Arrays.toString(booleans));
}