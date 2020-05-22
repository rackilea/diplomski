String input= "$.store.book[Random(1,9)].title";
System.out.println("Input: "+ input);
Pattern p = Pattern.compile("(?<=\\[)Random\\((\\d+),(\\d+)\\)(?=\\])");
Matcher m = p.matcher(input);
String output = input;
if(m.find()) {
    int min = Integer.valueOf(m.group(1));
    int max = Integer.valueOf(m.group(2));
    int rand = min + (int)(Math.random() * ((max - min) + 1));
    output = output.substring(0, m.start()) + rand + output.substring(m.end());
}
System.out.println("Output: "+ output );