String s = "https://address.com/somestring/somestring-2/c100.200.3.4/somestrigx3/somestring.4";
Pattern pattern = Pattern.compile("(?<=/c)(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2)); 
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
}