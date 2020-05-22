String rx = "(?sm)(\\G(?!\\A)|^sufixpart$)(?:(?!^(?:sufixpart|end)$).)*?(subdata\\S*)(?=.*?^end$)";
String s = "invalidsufix\nsubadatax\nsufixpart\nsubdata1\nsomerandomn\nsubdata2\nsubdatan\nend\ninvalidsufix\nsubadatax\nsufixpart\nsubdata001\nsomerandomn\nsubdata002\nsubdata00n\nend";
Pattern pattern = Pattern.compile(rx);
Matcher matcher = pattern.matcher(s);
List<List<String>> res = new ArrayList<>();
List<String> lst = null;
while (matcher.find()){
    if (!matcher.group(1).isEmpty()) {
        if (lst != null) res.add(lst);
        lst = new ArrayList<>();
        lst.add(matcher.group(2));
    } else lst.add(matcher.group(2)); 
} 
if (lst != null) res.add(lst);
System.out.println(res);