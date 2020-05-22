public static void main(String[] argv) throws FileNotFoundException {
  String input = "yXX00002200000\r\nXX00003300000\nshort", regex = ".{6}22.{5}\\s+.{6}33.{5}", result = "";
  Pattern pattern = Pattern.compile(regex);
  Matcher m = pattern.matcher(input);

  while (m.find()) {
   result = m.group();
   System.out.println(result);
  }
 }