static boolean CheckValue1(){

 Scanner sc = new Scanner(System.in);    
 try {
          System.out.println("Please input an integer:  ");
          number =sc.nextDouble();
          return true;
 }
 catch(InputMismatchException exception) {
          //Print "This is not an integer"
          //when user put other than integer
            System.out.println("   Please do not type letters");


            return false;
        }
}