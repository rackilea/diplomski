String myString = "9aie3ra3nr23rr5r21t";
System.out.println(upperCaseRandom(myString, 10));


public static String upperCaseRandom(String input, int n) {
 StringBuilder output = new StringBuilder(input);
 Random r = new Random();

 for (int i = 0; i < n; i++) {
  // Pick a place
  int position = r.nextInt(input.length());

  // Check if lowercase alpha
  if (Character.isLowerCase(output.charAt(position))) {
   output.setCharAt(position, Character.toUpperCase(output.charAt(position)));
  } else {
   i--;
  } 
 } 
 return output.toString();
}