int k = 7;
int m = 13;
int x = 6;
int y = x;
for (int i = 0; i < k; i++) {
    for (int j = 0; j < m; j++) {
        if (j<x)
            System.out.print(" ");
        if (j>=x && j<=y)
            System.out.print("*");
    }
    System.out.println();
    x--;
    y++;
}