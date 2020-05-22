public static void main(String arg[]) {
    int[] in = { 1, 2, 3, 0, 4, 3 };
    int[] out = multiplicity(in);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < out.length; i++) {
        if (i != 0) {
            sb.append(' ');
        }
        sb.append(out[i]);
    }
    String expected = "1 2 2 3 3 3 4 4 4 4 3 3 3";
    System.out.println(expected.equals(sb.toString()));
}