static void generators() {
    int i;
    int[] intArray = new int[10];
    for (i = 0; i <10; i++) {

        intArray[i] = randomFill();
    }
    System.out.println(Arrays.toString(intArray));
}

private static int randomFill() {

    return new Random().nextInt(100);
}