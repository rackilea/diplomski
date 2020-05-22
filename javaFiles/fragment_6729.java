private static int getVersion(Map<String, String> dir) {
        String objectName = dir.get("objectName");
    // Get the various parts of the name
        String[] nameParts = objectName.split("/");
    // Get the version from the nameParts
        String[] versionString = nameParts[nameParts.length - 1].split("\\.");
        // Parse version String into an int
        return (Integer.valueOf(versionString[0]) * 1000000)
                + (Integer.valueOf(versionString[1]) * 10000)
                + (Integer.valueOf(versionString[2]) * 100);
    }

    private static Map<String, String> storageDirectorySort(
            List<Map<String, String>> newDirs) {

        Map<String, String> latestVersion = null;
        for (Map<String, String> bundle : newDirs) {
            int version = getVersion(bundle);
            if (latestVersion == null || version > getVersion(latestVersion)) {
                latestVersion = bundle;
            }
        }

        return latestVersion;
    }