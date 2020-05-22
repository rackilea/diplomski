@Override
public Class<?> getColumnClass(int columnIndex) {
    Class classType = String.class;
    switch (columnIndex) {
        case 4:
            classType = Boolean.class;
            break;
    }
    return classType;
}