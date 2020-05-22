String s = "bla Country: Australia <bla";

Pattern pattern = Pattern.compile("Country: (.*) [<]");
Matcher matcher = pattern.matcher(s);
if(matcher.find()) {
    System.out.println("Country = " + matcher.group(1));
}