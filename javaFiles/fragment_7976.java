long time = System.currentTimeMillis();
String reg = "&(?!&#?[a-zA-Z0-9]{2,7};)";
Pattern p = Pattern.compile(reg);
String s="a regex test 1 & 2  1&2 and &_gt; - &_lt;";
for (int i = 0; i < 100000; i++) {
    String test = p.matcher(s).replaceAll("&amp;");
}
System.out.println("Finished in:" + 
             (System.currentTimeMillis() - time) + " milliseconds");