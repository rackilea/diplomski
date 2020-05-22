String matcher = "[a-zA-Z]*[0-9]+";
String[] s = text.split(regex);
List<String> result = new ArrayList<>();
String tmp = "";
for (String x : s) {
    if (x.matches(matcher)) {
        tmp += x;
    } else {
        if (!tmp.isEmpty()) {
            result.add(tmp);
            tmp = "";
        }
        result.add(x);
    }
}
if(!tmp.isEmpty()) {
    result.add(tmp);
}