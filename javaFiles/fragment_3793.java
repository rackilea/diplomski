public static void main(String[] args) {
    // TODO Auto-generated method stub
    String title, author, id;

    Scanner myScan = new Scanner( System.in );

    System.out.print( "Please enter id: " );
    id = myScan.nextLine();

    System.out.print( "Please enter name: " );
    title = myScan.nextLine();

    System.out.print( "Please enter author: " );
    author = myScan.nextLine();

    System.out.print("You entered: " + id + " " +  title + " " + author);

}