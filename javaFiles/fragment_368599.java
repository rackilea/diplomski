int lineCount = 5;
for (int i = 1; i <= lineCount; i++) {
    int value = i;
    for (int j = 1; j <= i; j++) {
        System.out.print(value +  " ");
        value += lineCount -j;
    }
    System.out.println("");
}