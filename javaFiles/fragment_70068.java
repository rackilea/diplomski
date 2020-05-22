String s = "We have the number 10 and 10.3, and i want to split both";
Pattern pattern = Pattern.compile("\\D+|\\d*\\.?\\d+");
Matcher matcher = pattern.matcher(s);
List<String> res = new ArrayList<>();
while (matcher.find()){
    res.add(matcher.group(0)); 
} 
System.out.println(res);