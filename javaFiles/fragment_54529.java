public class EnvironmentPanel
    extends JPanel
    implements Comparator<String>
{
    private static final long serialVersionUID = 1L;

    private static final String[] mHeader =
    {
        "Name",
        "Value",
    };

    private JTable mEnvironmentTable = null;
    private DefaultTableModel mTableModel = null;
    private int mSortOrder = 1;

    public EnvironmentPanel()
    {
        initialize();
    }

    private void initialize()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(3, 3, 3, 3);
        gbc_scrollPane.weighty = 1.0;
        gbc_scrollPane.weightx = 1.0;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        add(scrollPane, gbc_scrollPane);

        scrollPane.setViewportView(getMEnvironmentTable());
    }

    private JTable getMEnvironmentTable()
    {
        if(mEnvironmentTable == null)
        {
            mEnvironmentTable = new JTable();
            mEnvironmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            mTableModel = new DefaultTableModel();
            mEnvironmentTable.setModel(mTableModel);
            for(int i = 0; i < mHeader.length; i++)
                mTableModel.addColumn(mHeader[i]);
            Object[] row = new Object[mHeader.length];
            row[0] = "";
            mTableModel.addRow(row);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
            mEnvironmentTable.setRowSorter(sorter);
            sorter.setModel(mTableModel);
            sorter.setComparator(0, this);
            sorter.setSortsOnUpdates(true);
            sorter.addRowSorterListener(new RowSorterListener()
            {
                @Override
                public void sorterChanged(RowSorterEvent oEvent)
                {
                    if(oEvent.getType().equals(Type.SORT_ORDER_CHANGED))
                        mSortOrder *= (-1);
                }
            });

            mTableModel.addTableModelListener(new TableModelListener()
            {
                public void tableChanged(TableModelEvent oEvent)
                {
                    onTableChanged(oEvent);
                }
            });
        }
        return mEnvironmentTable;
    }

    /**
     * The table will always have an empty line at the end. If a new name is entered
     * the value is taken and a new line will be added.
     * Entries with an empty name column will be removed.
     * 
     * The name must be unique.
     * 
     * @param oEvent
     */
    private void onTableChanged(TableModelEvent oEvent)
    {
        String s = null;
        Map<String, Integer>nmap = new HashMap<String, Integer>();

        for(int i = mTableModel.getRowCount()-2; i >= 0; i--)
        {
            s = (String)mTableModel.getValueAt(i, 0);
            if(s == null || s.equals(""))
            {
                mTableModel.removeRow(i);
                continue;
            }

            // If we found an entry with the same name, we remove the one
            // that is later in the list.
            if(nmap.containsKey(s))
            {
                int pos = nmap.get(s);
                mTableModel.removeRow(pos);
            }

            // Add the latest row to the map.
            nmap.put(s,  i);
        }

        int n = mTableModel.getRowCount();
        if(n > 0)
        {
            s = (String)mTableModel.getValueAt(n-1, 0);
            if(s != null && s.equals("") == false)
            {
                Object[] row = new Object[mHeader.length];
                row[0] = "";
                mTableModel.addRow(row);
            }
            else
            {
                s = (String)mTableModel.getValueAt(n-1, 1);
                if(s != null && s.equals("") == false)
                    mTableModel.setValueAt(null, n-1, 1);
            }
        }
    }

    @Override
    public int compare(String oLeft, String oRight)
    {
        if(oLeft.equals(""))
            return -1*mSortOrder;

        if(oRight.equals(""))
            return 1*mSortOrder;

        return oLeft.compareTo(oRight);
    }
}