String text = "sdsas<D-10-helloworld-84>kjvkjv";

Pattern pattern = Pattern.compile("<[ED]-[0-9]{2}-(.*?)-[0-9]{2}>");
Matcher matcher = pattern.matcher(noiseFrame);
if (matcher.find()) {
    String newText = matcher.group(1);
    System.out.println(newText);
}