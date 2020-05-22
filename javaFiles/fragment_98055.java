String[] header = new String[] {
    "Name",
    "Full path",
    "Last modified",
    "Read",
    "Write",
    "Execute",
    "Hidden",
    "Directory"
};

DataObjectTableModel<File> model = new DataObjectTableModel<File>(Arrays.asList(header)) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return Date.class;
            case 3: return Boolean.class;
            case 4: return Boolean.class;
            case 5: return Boolean.class;
            case 6: return Boolean.class;
            case 7: return Boolean.class;
                default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        File file = getDataObject(rowIndex);
        switch (columnIndex) {
            case 0: return file.getName();
            case 1: return file.getAbsolutePath();
            case 2: return new Date(file.lastModified());
            case 3: return file.canRead();
            case 4: return file.canWrite();
            case 5: return file.canExecute();
            case 6: return file.isHidden();
            case 7: return file.isDirectory();
                default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }
};