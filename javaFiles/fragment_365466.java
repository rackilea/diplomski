for (int i=n-1; i >= 0; i--) {
    for (int j=0; j <= i; j++) {
        euroMatrix[i][j] = 0.01*Math.floor((expTermNeg * (p*euroMatrix[i+1][j+1] + (1 - p)*euroMatrix[i+1][j]))*100.00);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        String result = df.format(euroMatrix[i][j]);
        System.out.println(result); // prints 5.48 for 5.479999999999997
    }
}