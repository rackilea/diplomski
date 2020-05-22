for (int i=0;i<input.size();i++) {
  try {
    int parsedValue = Integer.parseInt(input.get(i).split(":")[1]);
    // do whatever you want to do with parsedValue
  }
  catch(NumberFormatException e) {
    System.out.print("I caught an error!, what i was trying to parse wasn't a number");
    // or any other action you consideer that needs to be done when parseInt fails
  }
}