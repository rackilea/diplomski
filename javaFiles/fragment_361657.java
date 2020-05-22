public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Type anything: ");
    String input = scan.next();

    while(!input.equals("exit")){
        System.out.println("Token: " + input);
        System.out.println("\nType anything: ");
        input = scan.next();
    }
    scan.close();
}