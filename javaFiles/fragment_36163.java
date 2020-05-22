public static void staircase(int n) {
    var sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
        sb.append(" ".repeat(n - i)).append("#".repeat(i)).append('\n');
    }

    System.out.print(sb);
}