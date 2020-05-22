List<String> errors = new LinkedList<>();

//check the name
if (nameNew == null || nameNew.trim().isEmpty()) {
    errors.add("name should not be empty");
}

//check the points
if (pointsNew < 3 || pointsNew > 20) {
    errors.add("points should be between 3 and 20");
}

//if there are errors, throw an exception
if(!errors.isEmpty()) {
  //for simplicity we'll use IllegalArgumentException and concat the messages with a newline 
  //in a realworld application it would probably be best to use a custom exception and keep the list of errors
  throw new IllegalArgumentException(String.join("\n", errors));
}