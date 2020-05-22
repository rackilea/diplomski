public static void main(String[] args) {
    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    /**
     * Populate hashmap.. Your logic goes here
     */
    Scanner sc = new Scanner(System.in);
    int x;
    System.out.println("Enter a number between 1 and 12");
    do {
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Enter a number between 1 and 12");
            sc.next();
        }
        x = sc.nextInt();
        String month = hm.get(x);
        System.out.println("The corresponding month is " + month);
    } while (x >= 0);

}