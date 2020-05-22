public static void findMatching(String matchOne, String matchTwo) {
  int lengthOne = matchOne.length();
  int lengthTwo = matchTwo.length();
  char charOne;
  char charTwo;

  for(int i = 0; i < lengthOne || i < lengthTwo; i++) {
    if(i < lengthOne && i < lengthTwo) {
        charOne = matchOne.charAt(i);
        charTwo = matchTwo.charAt(i);
        if (charOne == charTwo) {
           System.out.print(charTwo);
        } else {
           System.out.print(".");
        }
    } else {
       System.out.print(".");
    }

  }
}