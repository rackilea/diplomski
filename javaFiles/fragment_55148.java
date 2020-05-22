public String[] getFilesList(File path) {
    int deepth = 1; // Control the deepth of recursion
    List<String> list = new ArrayList<String>();
    getFilesList(path, list, deepth);
    return list.toArray(new String[list.size()]);
}

public void getFilesList(File path, final List<String> list, int deepth) {
    if (deepth >= 0) {
        final int newDeepth = deepth - 1;
        String[] subList = path.list(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            File subFile = new File(dir.getAbsolutePath() + "/" + name);
            if (subFile.isFile()) {
                if (name.matches(Constants.INTERNA_REGEX)) {
                return true;
            } else if (name.matches(Constants.SISS_REGEX)) {
                return true;
            } else {
                // log.info("Invalid file or directory: " + name);
                return false;
            }
        } else {
            getFilesList(subFile, list, newDeepth);
        }
        return false;
      }
    });

    list.addAll(Arrays.asList(subList));
    }
}