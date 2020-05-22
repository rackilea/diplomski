int n = s.length() - 1;
int i, j;
for (i = 0; i <= n; i++) {
    for (j = 0; j <= n; j++) {
        if (i == j || i == n - j)
            System.out.print(s.charAt(i));
        else {
            System.out.print("*");
        }
    }
    System.out.println();
}