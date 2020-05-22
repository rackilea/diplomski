String s = "Created by CreateImage(i-b9b4ffaa) for ami-dbcf88b1 from vol-e97db305";
Pattern pattern = Pattern.compile("(?i)\\b[a-z]+-[a-z0-9]+");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
} 
// => i-b9b4ffaa, ami-dbcf88b1, vol-e97db305