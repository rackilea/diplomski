public static void main(String[] args) {
    System.out.println(conway1d("0000001", 7, 1));
    System.out.println(conway1d("01011", 5, 3));
}

private static String conway1d(CharSequence input, int N, long T) {
    System.out.println("Generation 0: " + input);

    StringBuilder sb = new StringBuilder(input); // Will update this for all generations

    StringBuilder copy = new StringBuilder(); // store a copy to reference current generation
    for (int gen = 1; gen <= T; gen++) {
        // Copy over next generation string
        copy.setLength(0);
        copy.append(input);

        for (int i = 0; i < N; i++) {
            conwayUpdate(sb, copy, i, N);
        }

        input = sb.toString(); // next generation string
        System.out.printf("Generation %d: %s\n", gen, input);
    }

    return input.toString();
}

private static void conwayUpdate(StringBuilder nextGen, final StringBuilder currentGen, int charPos, int N) {
    int prev = (N + (charPos - 1)) % N;
    int next = (charPos + 1) % N;

    // **Exactly one** adjacent '1'
    boolean adjacent = currentGen.charAt(prev) == '1' ^ currentGen.charAt(next) == '1';
    nextGen.setCharAt(charPos, adjacent ? '1' : '0'); // set cell as alive or dead
}