public Class<?> getColumnClass(int columnIndex) {
 Class cls=null;// don't use Class class since class is a key word in Java
    switch (columnIndex) {
        case 0:
            cls = Integer.class;
            break;
        case 1:
            cls = String.class;
            break;
        case 2:
            cls = ArrayList.class;
            break;
    }
    return cls; 
}