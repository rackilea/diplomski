static int count(String[][] list, String s, int n) { //n is the number of rows
    int x=0;
    for (int i=1;i<=n;i++) {
        for (int j=1;j<list[i].length;j++) {
            if (list[i][j].equals(s)) {
                x++;
            }
        }
    }
    return x;
}