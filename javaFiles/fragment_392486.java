public static int findMinCoins(int[] currency, int amount) {
    int min = findMinCoins(currency, amount, 0);
    System.out.print("The coins used were: ");
    return min;
}
private static int findMinCoins(int[] currency, int amount, int min){
    int number, value1, value2;
    int min1 = min;
    for(int i=currency.length-1; i>=0; i--) {
        if (amount>=currency[i]){
            amount = amount - currency[i];
            System.out.print(currency[i] + " ");
            min1 = findMinCoins(currency, amount, min1);
            return ++min1;
        }
    }
    return min1;
}