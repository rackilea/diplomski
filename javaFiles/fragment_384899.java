String input = "((1,2,3),(3,4,5),(2,3,4))";
input = input.substring(1, input.length() - 1);

// split on commas followed by "(" and preceded by ")"
String[] array = input.split("(?<=\\)),(?=\\()");

System.out.println(Arrays.toString(array));