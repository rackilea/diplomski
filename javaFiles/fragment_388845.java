String txt="sources: [{file:\"http://pla.cdn19.fx.rrrrrr.com/luq5t4nidtixexzw6wblbiexs7hg2hdu4coqdlltx6t3hu3knqhbfoxp7jna/normal.mp4\",label:\"360p\"}],sources: [{file:\"http://pla.cdn19.fx.rrrrrr.com/luq5t4nidtixexzw6wblbiexs7hg2hdu4coqdlltx6t3hu3knqhbfoxp7jna/normal.mp4\",label:\"360p\"}]";

Matcher matcher = Pattern.compile("sources: \\[\\{file:\"(.*?)\"").matcher(txt);

ArrayList<String> getfi = new ArrayList<String>();
while (matcher.find()) {
    getfi.add(matcher.group(1));
}
if (getfi.isEmpty()) {
    System.exit(1);
}
System.out.println(getfi);