// input, you have to read your EditText
  String input = "003645";    // your example
  int significantFigures = 3; // your example

  // calculation
  int number = Integer.parseInt(input, 10);
  int tooBig = (int) Math.pow(10, significantFigures);
  while (number > tooBig) {
      number = (int) Math.round(number / 10.0);
  }
  System.out.println(number); // prints 365