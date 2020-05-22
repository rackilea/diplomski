Pattern reg = Pattern.compile("^https?:\\/\\/(?!.*:\\/\\/)\\S+");
Matcher m = reg.matcher("http://somesite.com"); 
if (m.find()) {
    System.out.println(m.group());
} else {
    System.out.println("No match");
}