@Override
public Class getColumnClass(int column)
{
    switch (column)
    {
        case 0: return Double.class;
        case 3: return Double.class;
        case 6: return Double.class;
        default: return Object.class;
    }
}