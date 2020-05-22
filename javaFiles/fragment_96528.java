@Override
public Object getValueAt(int row, int column)
{
    JButton button = getRow(row);

    switch (column)
    {
        case 0: return button.getText();
        case 1: return button.getToolTipText();
        case 2: return button.isEnabled();
        case 3: return button.isVisible();
        default: return null;
    }
}