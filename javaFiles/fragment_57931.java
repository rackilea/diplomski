@Override
public Class getColumnClass(int column) {
    switch (column) {
        case 0:
            return Date.class;
        case 1:
            return Long.class;
        case 2:
            return Boolean.class;
        case 3:
            return Boolean.class;
        case 4:
            return Boolean.class;
        default:
            assert false;
    }
    return null;
}

@Override
public Object getValueFor(Object node, int column) {
    File f = (File) node;
    switch (column) {
        case 0:
            return new Date(f.lastModified());
        case 1:
            return f.length();
        case 2:
            return f.canRead();
        case 3:
            return f.canWrite();
        case 4:
            return f.canExecute();
        default:
            assert false;
    }
    return null;
}