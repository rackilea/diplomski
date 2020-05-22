try {
  ... parsing code ...
}
catch (Exception exc) { // change this to catch the specific type of exceptions relevant to the parsing
    System.out.println(exc.getMessage()); // or redirect the message to a file
}