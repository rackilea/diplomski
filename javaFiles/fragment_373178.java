java.util.List<File> result = new ArrayList<File>();
    final String searchFor = "fixedName";

    for (File child : f.listFiles()) {
        result.addAll(Arrays.asList(
            child.listFiles(new FilenameFilter() {
                public boolean accept(File parent, String childName) {
                    return childName.equals(searchFor);
                }
            }
        )));
    }