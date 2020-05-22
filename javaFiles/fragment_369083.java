public static void box (int length, int width, String character){ 

    Scanner input = new Scanner (System.in) ;

    for (int i = 0; i < length; i++) {
           for (int j = 0; j < width; j++) {
                System.out.print(character +" ");
            }
            System.out.println("");
        }
    }





public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner input = new Scanner (System.in);  

    int length, width ; 
    String Answer; 
    String character = ""; 

    System.out.println("Do you want to use a special character to use to display the box ?"); 
      Answer = input.next();

  if (Answer.equals("Yes")){
    System.out.println("Please enter the character that you would like to display the box");
     character =  input.next();
  }

  if (Answer == "No"){
      character = "*"; 
  }
    System.out.println ("Please enter the length of the box"); 
    length = input.nextInt();
    System.out.println (" Please enter the width of the box");
    width = input.nextInt(); 

    input.close(); 


    box (length, width, character); 


}
}