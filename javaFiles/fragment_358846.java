public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //create a new scanner 

    ToBeReversed = input.nextLine();
    System.out.println("ToBeReversed = " + ToBeReversed);
    Reverse.reversal();
    System.out.println("newString = " + newString);
    System.out.println(Reverse.putTogether());

}