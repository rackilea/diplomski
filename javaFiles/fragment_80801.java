//finds largest Value
int largestValue = numbersArray[0];
for (int i = 1; i < numbersArray.length; i++) {
    if (numbersArray[i] > largestValue) {
        largestValue = numbersArray[i];
    }
}

//Prints number of asterisks
final int MAX = 40;
for (int i = 0; i < numbersArray.length; i++) {
    int portion = (int)(MAX * (numbersArray[i] / (float)largestValue));
    for (int j = 0; j < portion; j++) {
        System.out.print("*");
    }
    System.out.println();
}