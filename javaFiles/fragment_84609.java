String s = "Rendering content from websiteNAme using user agent userAgent Name WithSpaces ; for user username ; at time someTime";
Pattern pattern = Pattern.compile("Rendering content from (.*) using user agent ([\\w ]+) ; for user (.*) ; at time (.*)");
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
}