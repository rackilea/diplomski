String input = "Bob:23456:12345 Carl:09876:54321";
String[] words = input.split(" ")

for (String word : words) {
  String[] token = each.split(":");

  String name = token[0];
  int value0 = Integer.parseInt(token[1]);
  int value1 = Integer.parseInt(token[2]);    
}