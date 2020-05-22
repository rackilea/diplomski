for (int k = 1; k < n; k++) {   // SHOULD BE k <= n.
    for (int i = 0; i < Math.log10(k); i++) {  // AGAIN USE <=
        // USE CEILING AND FLOOR FUNCTIONS NOT POWER. USE DOUBLE PRECISION NOT INTEGER.
        loop1 += (1 - ((((k / Math.pow(10, i)) - (10 * (k / Math.pow(10, i + 1))))) / 10));
    }

}