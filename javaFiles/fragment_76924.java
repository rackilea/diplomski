String text = "12 101";
String[] split= text.split("\\s+");
String first = split[0];
String second = split[1];

//if you want them as ints
int firstNum = Integer.parseInt(first);
int secondNum = Integer.parseInt(second);