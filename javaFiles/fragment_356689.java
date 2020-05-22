public static void main(String args[]) {
    String c = "Message";
    char character;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the character : ");
    character = sc.next().charAt(0);
    System.out.println();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 13; j++) {
            if (i == 0 || i == 2) {
                System.out.print(character);
            } else if (j == 0) {
                String middle = character + "  " + c + "  " + character;
                System.out.print(middle);
            } 
        }
        System.out.println();
    }
}