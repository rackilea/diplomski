String s = "/something/test/{abc}/listed";
Pattern pattern = Pattern.compile("/test/([^/]+)"); // or "/test/\\{([^/}]+)"
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(1)); 
}