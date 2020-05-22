TableModelListener tml = new TableModelListener()
{

    public void tableChanged(TableModelEvent e)
    {
        if (e.getType() == TableModelEvent.UPDATE)
        {
            int column = e.getColumn();

            if (column == ???)
            {
                TableModel model = (TableModel)e.getSource();
                double total = 0;

                for (int row = 0; row < model.getRowCount(); row++)
                {
                    double value = ((Double)model.getValueAt(row, ???2)).doubleValue();
                    total += value;
                }

                System.out.println( total );
            }
        }
    }
});

JTable table = new JTable(...);
table.getModel().addTableModelListener(tml);