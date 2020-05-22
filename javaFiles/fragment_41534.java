public static double inputValidator(){
  Scanner scanner = new Scanner(System.in);
  System.out.println("enter a value"); // prompt user for input
  String getData = scanner.next(); // get input
  if(getData.length() >= 1){
        if(!Character.isDigit(getData.charAt(0)) && getData.charAt(0) != '-') throw new NonDigitNumberException();
  }
  for (int i = 1; i < getData.length(); i++) {
     if(!Character.isDigit(getData.charAt(i))) throw new NonDigitNumberException();
  }
  return Double.parseDouble(getData); // at this point the input data is correct
}