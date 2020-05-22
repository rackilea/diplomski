String input = "<div style='background-image: url(http://www.mydomain.com/images/test.jpg); \n" +
                "background-repeat: no-repeat; background-attachment: scroll; height: 400px;'>";

Pattern pattern = Pattern.compile("image:\\surl\\(([^)]+)\\)");
Matcher matcher = pattern.matcher(input);
if (matcher.find()){
    String url = matcher.group(1);
    System.out.println(url);
}