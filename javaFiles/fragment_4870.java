for (int i = 0; i < in.nextInt(); i ++) {
    System.out.println("Enter a value for second array, position "+ i);
    try {
        secondArray[i] = Integer.parseInt(sc.nextLine());
        totals[i] = fistArray[i] + secondArray[i];
    } catch (Exception e) {
        System.out.println("Not a valid number!!!);
        i --;
    }
}