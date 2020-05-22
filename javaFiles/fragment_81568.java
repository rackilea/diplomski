String input = "Z = 4329x1 + 3901x22 + 6716x3";
input = input.replaceAll("^\\D+", "");
double[] numbers = Pattern.compile("x\\d+\\D*")
                          .splitAsStream(input)
                          .mapToDouble(Double::parseDouble)
                          .toArray();