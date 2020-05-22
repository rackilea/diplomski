final String versionString = "v1_00";
final String regex = "v(\\d+)_(\\d+)(?:_(\\d+))?";
final Matcher matcher = Pattern.compile(regex).matcher(versionString);
if (matcher.matches()) {
    final int version = Integer.parseInt(matcher.group(1));
    final int interimVersion = Integer.parseInt(matcher.group(2));
    int patchVersion = 0;
    if (matcher.group(3) != null) {
        patchVersion = Integer.parseInt(matcher.group(3));
    }
    System.out.println(version + " > " + interimVersion  + " > " + patchVersion);
}