class Main{
  public static void main(String[] a){
    String[] array = {"first", "top", "second", "third", "bottom"};

    // Create the regex-String of the array once:
    String regex = "^.*(";
    for(int i=0; i<array.length; i++){
      regex += array[i];
      if(i < array.length - 1) // All except for the last word in the array:
        regex += "|";
    }
    regex += ").*$";

    // Check all user inputs:
    // TODO: Actually use user inputs instead of this String-array of test cases of course
    for(String userInputTestCase : new String[]{"mine is the first one",
                                                "its the one at the bottom",
                                                "no match",
                                                "top and bottom",
                                                "first"}){
      System.out.println(userInputTestCase + " → " + userInputTestCase.matches(regex));
    }
  }
}