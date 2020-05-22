//Take something that starts with "<ol start=", ends with ">", and has a number in between
Matcher m = Pattern.compile("<ol start=\"(\\d)\"(.*?)>").matcher(htmlString);
while (m.find()) {
    int n = Integer.parseInt(m.group(1));
    htmlString = htmlString.replaceAll("(<ol start=\"" + n + "\")(.*?)(>)",
            "<ol $2>" + StringUtils.repeat("\n\t<li style=\"visibility:hidden\" />", n - 1));
}