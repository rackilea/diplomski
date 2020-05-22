String content = "aba(2)bb(52)gc(4)d(2)fe(14)f(6)g(8)h(4)5(6)";
Pattern pattern = Pattern.compile("[a-g](?:\\(\\d+\\))?");
List<String> res = new ArrayList<>();
Matcher matcher = pattern.matcher(content);
while (matcher.find()){
    res.add(matcher.group(0)); 
} 
System.out.println(res);