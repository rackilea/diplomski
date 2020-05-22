public class FailFastFileFilter implements FileFilter {
    protected final List<FileFilter> children = new ArrayList<FileFilter>();

    public FailFastFileFilter(FileFilter... filters) {
        for (FileFilter filter: filters) {
            if (filter != null)
                this.filters.add(filter);
        }       
    }

    public boolean accept(File pathname) {
        for (FileFilter filter: this.filters) {
            if (!filter.accept(pathname)) {
                return false; // fail on the first reject
            }
        }

        return true;
    }
}