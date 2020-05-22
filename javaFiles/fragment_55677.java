String input = "abc/def/ghi/jkl/mno/pqr";
String[] output = input.split("/");

for (int i = 0; i < output.length; i++) {
  output[i] += "/";
}