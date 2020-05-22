private void copyFiles(File src, File tgt, FileFilter... filters) {
    /*...*/
    File[] filePaths = src.listFiles(new GroupedFileFiler(filters));
    /*...*/
}

public class GroupedFileFilter implements FileFilter {

    private FileFilter[] filters;

    public GroupedFileFilter(FileFilter... filters) {
        this.filters = filters;
    }

    @Override
    public boolean accept(File pathname) {
        boolean include = true;
        if (filters != null && filters.length > 0) {
            for (FileFilter filter : filters) {
                include = filter.accept(pathname);
                if (!include) {
                    break;
                }
            }
        }
        return include;
    }
}