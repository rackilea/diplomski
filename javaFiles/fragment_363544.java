public static void main(String[] args) {

    System.out.println("Welcome to my integer  Roman numeral conversion program");
    System.out.println("------------------------------------------------------");
    System.out.println(" ");

    Scanner in = new Scanner (System.in);
    String choice;
    do{
        System.out.print("Enter an integer in the range 1-3999 (both inclusive): ");
        int input = in.nextInt();
        if(input > 0 && input < 3999){
            System.out.println(Conversion.Convert(input));
        }
        else{
            System.out.println("Sorry, this number is outside the range.");
        }
        System.out.println("Do you want to try again? Press Y for yes and N for no: ");
        choice = in.next();
    }while(choice.equals("Y") || choice.equals("y"));
}