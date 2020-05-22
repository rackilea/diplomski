String s = "If this is good and if that is bad";
Pattern pattern = Pattern.compile("if(.*?)is");
Matcher m = pattern.matcher(s);
if(m.find()){
    System.out.println(m.group(1).trim());
}