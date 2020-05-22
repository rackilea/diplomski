try {
    dim = keyboard.nextInt();
} catch (Exception e) {
    System.out.printf("%s is not an integer.%n", keyboard.next());
    err = 1;
}