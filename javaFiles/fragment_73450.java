int n = Integer.parseInt(br.readLine());
double a[][] = new double[n][];
double b[] = new double[n];
for (int i = 0 ; i != n ; i++) {
    String[] tok = br.readLine().split(",");
    a[i] = new double[tok.length-1];
    for (int j = 0 ; j != a[i].length ; j++) {
        a[i][j] = Double.parseDouble(tok[j]);
    }
    b[i] = Double.parseDouble(tok[tok.length-1]);
}