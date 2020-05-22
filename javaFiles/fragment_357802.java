public static void main(String [] args) {
       String [] thisIsAStringArray = new String[20]; //Only 20 string can be saved.
       Scanner in = new Scanner(System.in);
      for(int i = 0; i < 100;i++) {
        thisIsAStringArray[0] = in.nextLine(); ///Save element to first position.
        System.out.println("String entered is " + thisIsAStringArray[0]); //Get the element from the first position.
       }

}