Pattern ptrn = Pattern.compile("[^\\s\\W]+|\\S+");
Matcher m = ptrn.matcher("We have not met, have we?!!");
List<String> list = new ArrayList<>();
while (m.find()) {
    list.add(m.group(0));
}
System.out.println(list); // => [We, have, not, met, ,, have, we, ?!!]