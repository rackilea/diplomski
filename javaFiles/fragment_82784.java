String str = "from abc.xyz.com (abc.xyz.com. [112.35.4.152]) by xx.yy.com with ESMTPS id ...";
Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
Matcher matcher = pattern.matcher(str);

if (matcher.find()) {
    System.out.println(matcher.group(0));
} else {
    System.out.println("No match.");
}