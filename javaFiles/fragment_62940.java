String s = "https://address.com/somestring/somestring-2/c100.200.3.4/somestrigx3/somestring.4";
Pattern pattern = Pattern.compile("(?<=/c)(\\d+)|(?!^)\\G\\.(\\d+)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    if (matcher.group(1) != null)
        System.out.println(matcher.group(1));
    if (matcher.group(2) != null)
        System.out.println(matcher.group(2)); 
}