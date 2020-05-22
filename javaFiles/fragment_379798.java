String content = "Hello src=\"cid:something@gmail.com\" is present";
String contentId = "something@gmail.com";
Pattern pattern = Pattern.compile("\\s+(?i)src=\"cid(?-i):\\Q" + contentId + "\\E\"");

Matcher m = pattern.matcher(content);

if(m.find())
    System.out.println("Present");
else
    System.out.println("Not Present");