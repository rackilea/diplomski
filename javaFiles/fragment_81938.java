static int[] getVersionNumbers(String ver) {
    Matcher m = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(beta(\\d*))?")
                       .matcher(ver);
    if (!m.matches())
        throw new IllegalArgumentException("Malformed FW version");

    return new int[] { Integer.parseInt(m.group(1)),  // major
            Integer.parseInt(m.group(2)),             // minor
            Integer.parseInt(m.group(3)),             // rev.
            m.group(4) == null ? Integer.MAX_VALUE    // no beta suffix
                    : m.group(5).isEmpty() ? 1        // "beta"
                    : Integer.parseInt(m.group(5))    // "beta3"
    };
}

static boolean isFirmwareNewer(String testFW, String baseFW) {

    int[] testVer = getVersionNumbers(testFW);
    int[] baseVer = getVersionNumbers(baseFW);

    for (int i = 0; i < testVer.length; i++)
        if (testVer[i] != baseVer[i])
            return testVer[i] > baseVer[i];

    return true;
}