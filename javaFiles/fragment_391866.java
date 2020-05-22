public class GenericExtFilter implements FilenameFilter {
    private String[] exts;

    public GenericExtFilter(String... exts) {
        this.exts = exts;
    }

    @Override
    public boolean accept(File dir, String name) {
        for (String ext : exts) {
             if (name.endsWith(ext)) {
                 return true;
             }
        }

        return false;
    }
}