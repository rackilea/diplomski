public static void main(String[] args) {

    Scanner myInt = new Scanner(System.in);
    boolean acceptable=false;
    while(!acceptable){
        System.out.println("Enter a number between 1 and 10");

        int choice = myInt.nextInt();

        if (choice <= 10 && choice>=1) {
            System.out.println("acceptable");
            acceptable=true;
        } else {

            System.out.println("unacceptable");

        }
    }
}