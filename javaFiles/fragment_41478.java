PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

Path filename = ...;
if (matcher.matches(filename)) {
    System.out.println(filename);
}