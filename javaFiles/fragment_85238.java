int[] integerArray = {7, 13, 20, 5, 9, 32, 100, 6};
int elementsLargerThanTen = 0;
for (int i = 0; i < integerArray.length; i++) {
    if (integerArray[i] > 10) {
        elementsLargerThanTen++;
    }
}

System.out.printf("The number of elements larger than 10 is: %s", elementsLargerThanTen);