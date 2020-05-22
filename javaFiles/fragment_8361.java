private void printColRow(int[][] a){
    for(int i = 0; i < a[0].length; i++) {
        double sum = 0.0;
        for(int j = 0; j < a.length; j++)
            sum += a[j][i];
        System.out.println(sum + " ");
    }
}