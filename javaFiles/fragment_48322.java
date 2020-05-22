String input = "[number, number, number]";
String sep = ", ";
String fixedInput = input.replace("[", "").replace("]", "");
String[] array = fixedInput.split(sep);
// array[0] contains first number.
// array[1] contains second number.