public boolean containsLy(String input) {
  if (input == null || input.length() < 2) {
      return false;
  }
  else {
     String ly = "ly";
     String lastString = input.substring(input.length() - 2);
     if (lastString.equals(ly)) {
       return true;
     }
     else {
       return false;
     }
  }
}