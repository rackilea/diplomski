for (int i = 0; i < arr.length; i++) {
    try {
        System.out.printf("Please enter a number for arr[%d]:%n", i);
        arr[i] = scan.nextInt();
    } catch (Exception ex) {
        i--;
        System.out.printf("%s is not a number.%n", scan.next());
    }
}