List<String> strs = Arrays.asList("foo/bar/Samsung-Galaxy/a-b/1","foo/bar/Samsung-Galaxy/c-d/1#P2","foo.com/Samsung-Galaxy/9090/c-d/69");
Pattern pattern = Pattern.compile(".*/(?:a-b|c-d|e-f)/[^/]*?([0-9]+)");
for (String s : strs) {
    Matcher m = pattern.matcher(s);
    if (m.matches()) {
        System.out.println(s + ": \"" + m.group(1) + "\"");
    }
}