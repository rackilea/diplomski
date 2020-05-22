double d1;
try {
    d1 = Double.parseDouble(input1);
catch (NumberFormatException | NullPointerException e) {
    throw new MyCustomException("Please enter a valid double!", e);
}