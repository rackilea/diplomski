for (int i = 0; i < arrayLength; i ++) {
    System.out.println("Enter a value for first array, position "+ i);
    try {
        firstArray[i] = Integer.parseInt(sc.nextLine());
    } catch (Exception e) {
        System.out.println("Not a valid number!!!);
        i --;
    }
}