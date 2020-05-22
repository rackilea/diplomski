public static void main(String []args){
    System.out.println("How many cards to be distributed? ");
    Scanner keyboard = new Scanner(System.in);
    if (keyboard.hasNextInt()) {
        int cards = keyboard.nextInt();
        // ...
    }
 }