String s = "Created by CreateImage(i-b9b4ffaa) for ami-dbcf88b1 from vol-e97db305";
if (s.startsWith("Created by CreateImage")) {
    Matcher n = Pattern.compile("(?i)\\b[a-z]+-[a-z0-9]+").matcher(s);
    while(n.find()) {
        System.out.println(n.group(0)); 
    }
}