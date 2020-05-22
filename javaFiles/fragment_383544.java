private static final File[] EMPTY_LIST = {};

private File[] getFiles(File parent) {
    File[] files = parent.listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return !file.isHidden();
        }
    });
    return files != null ? files : EMPTY_LIST;
}

@Override
public int getChildCount(Object parent) {
    return getFiles((File) parent).length;
}

@Override
public Object getChild(Object parent, int index) {
    return getFiles((File) parent)[index];
}

@Override
public int getIndexOfChild(Object parent, Object child) {
    File[] files = getFiles((File) parent);
    for (int idx = 0; idx < files.length; idx++) {
        if (files[idx].equals(child))
            return idx;
    }
    return -1;
}