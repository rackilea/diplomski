String str = "[a,b,c,d],[1,2,3,4],[a,gf,d,cvb],[4,3,2,1]";
Pattern logEntry = Pattern.compile("\\[(.*?)\\]");
Matcher matchPattern = logEntry.matcher(str);
while (matchPattern.find()) {
    System.out.println("[" + matchPattern.group(1) + "]");
}