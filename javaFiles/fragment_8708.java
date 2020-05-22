String version = "1.0.1-RC";
Pattern versionPattern = Pattern.compile("([1-9]\\d*)\\.(\\d+)\\.(\\d+)(?:-([a-zA-Z0-9]+))?");
Matcher matcher = versionPattern.matcher(version);

if (matcher.matches()) {
    System.out.println("matching version is: " + matcher.group(0));
    System.out.println("major #: " + matcher.group(1));
    System.out.println("minor #: " + matcher.group(2));
    System.out.println("patch #: " + matcher.group(3));
    System.out.println("qualifier: " + matcher.group(4) + "\n\n\n");
}