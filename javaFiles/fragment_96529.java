@Override
public Object getValueAt(int row, int column)
{
    Student student = getRow(row);

    switch (column)
    {
        case 0: return student.getTeacherId();
        case 1: return student.getId();
        case 2: return ...;
        case 3: return ...;
        default: return null;
    }
}