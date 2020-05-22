try {
    i = reader.nextInt();
    break;  
} catch (InputMismatchException ex) {
    System.out.printf("%s is not an int. Please enter an integer:", reader.next());
}