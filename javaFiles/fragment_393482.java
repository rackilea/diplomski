String s = "http://w...content-available-to-author-only...e.com/page/support/28685875?JK.kj_id=";
Pattern pattern = Pattern.compile("(?<=/)[^/?]+(?=[?]|$)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group()); 
}