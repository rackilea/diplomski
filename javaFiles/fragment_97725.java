String s = "pr�s-*";
Pattern pattern = Pattern.compile("\\P{ASCII}");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}