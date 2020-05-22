public static void main(String[] args) {
    System.out.println("This program can randomize characters or numbers.");
    System.out.println("Please input \"c\" for characters, and \"n\" for numbers. ");
    Scanner choices = new Scanner(System.in);

    String keyword = choices.next();

    if (keyword.startsWith("c")) {
        cmethod();
    } else if (keyword.startsWith("n")) {
        nmethod();
    } else {
        System.out.println("Keyword is wrong.");
    }
}