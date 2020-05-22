final int start = 36*36*10 + (36*10) + 10;
for (int i = start; i < 36*36*36; ++i) {
    final String base36 = Integer.toString(i, 36);
    final String padded = String.format("%3s", base36).replace(' ', '0');
    System.out.println(padded);
}