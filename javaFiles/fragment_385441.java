String s = "a_Type_of_Data 0.847481:611x569+446+1200,0.515323:597x762+448+1101,0.587354:597x558+488+1207";
Pattern p = Pattern.compile("\\d+x\\d+(?:\\+\\d+){2}");
List<List<String>> list = new ArrayList<>();

Matcher m = p.matcher(s);
while(m.find()) {
    String[] data = m.group().split("[x+]");
    list.add(Arrays.asList(data));
}
list.forEach(System.out::print);