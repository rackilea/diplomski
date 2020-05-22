public static void main(String[] args) {
  int[] intArray=new int[6];
  int i = 0;
  String s = "123456";
  int strLength = s.length();
  if(strLength != 6) {
    System.out.println("Not a valid length");
  } else {
    for(i=0;i<6;i++) {
      if (!Character.isDigit(s.charAt(i))) {
        System.out.println("Contains an invalid digit");
        break;
      }
      intArray[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
    }
  }
  System.out.println(Arrays.toString(intArray));
}