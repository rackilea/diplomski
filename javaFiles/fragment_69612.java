public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    char answer; //<----declare the variable here 

do {
    System.out.println("Enter your first and last name:"); //<---use double quotes
    String name = s.nextLine();

    System.out.println("Enter your job description:");//<---use double quotes
    String job = s.nextLine();

    System.out.println("Press Y for loop ..");
    answer = s.nextLine().charAt(0); //<---use nextLine() here 
}while(answer == 'Y');
}