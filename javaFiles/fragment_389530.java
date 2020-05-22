public class JTableTest {


        private final DefaultCellEditor cellEditor;
        private final JTextField textfield;
        private JPanel panel;
        private MyTableModel tableModel = new MyTableModel();
        private JTable table = new JTable() {

            @Override
            public TableCellEditor getCellEditor(int row, int column) {               
                    return JTableTest.this.cellEditor;                
            }

            @Override
            public void changeSelection(
                    final int row, final int column, final boolean toggle, final boolean extend) {
                super.changeSelection(row, column, toggle, extend);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if ((getCellEditor(row, column) != null && !editCellAt(row, column))) {                        
                            JTextField textfield=(JTextField)JTableTest.this.cellEditor.getComponent();
                            textfield.selectAll();                          
                        }
                    }
                });
            }
        };

        public JTableTest() {
            JScrollPane scroll = new JScrollPane(table);
            table.setModel(tableModel);
            panel = new JPanel(new BorderLayout());
            panel.add(scroll, BorderLayout.CENTER);
            textfield = new JTextField();
            textfield.setEditable(Boolean.FALSE);
            textfield.setBorder(null);
            cellEditor = new DefaultCellEditor(textfield);
            tableModel.insertValue(new ItemRow("nonEditable", "Editable"));
        }



        private class ItemRow {

            private String column1;
            private String column2;

            public ItemRow(String column1, String column2) {
                this.column1 = column1;
                this.column2 = column2;
            }

            public String getColumn1() {
                return column1;
            }

            public void setColumn1(String column1) {
                this.column1 = column1;
            }

            public String getColumn2() {
                return column2;
            }

            public void setColumn2(String column2) {
                this.column2 = column2;
            }
        }

        private class MyTableModel extends AbstractTableModel {

            public static final int COLUMN1_INDEX = 0;
            public static final int COLUMN2_INDEX = 1;
            private final List<ItemRow> data = new ArrayList<>();

            private final String[] columnsNames = {
                "Column1",
                "Column2",};

            private final Class<?>[] columnsTypes = {
                String.class,
                String.class
            };


            public MyTableModel() {
                super();
            }

            @Override
            public Object getValueAt(int inRow, int inCol) {
                ItemRow row = data.get(inRow);
                Object outReturn = null;

                switch (inCol) {
                    case COLUMN1_INDEX:
                        outReturn = row.getColumn1();
                        break;
                    case COLUMN2_INDEX:
                        outReturn = row.getColumn2();
                        break;
                    default:
                        throw new RuntimeException("invalid column");
                }

                return outReturn;
            }

            @Override
            public void setValueAt(Object inValue, int inRow, int inCol) {
                System.out.println("Gets called ");
                if (inRow < 0 || inCol < 0 || inRow >= data.size()) {
                    return;
                }

                ItemRow row = data.get(inRow);
                switch (inCol) {
                    case COLUMN1_INDEX:
                        row.setColumn1(inValue.toString());
                        break;
                    case COLUMN2_INDEX:
                        row.setColumn2(inValue.toString());
                        break;
                }
                fireTableCellUpdated(inRow, inCol);
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return columnsTypes.length;
            }

            @Override
            public String getColumnName(int inCol) {
                return this.columnsNames[inCol];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return this.columnsTypes[columnIndex];
            }

            /**
             *
             * @param row
             */
            public void insertValue(ItemRow row) {
                data.add(row);
                fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }



        }


        private static void createAndShowGUI(final Container container, final String title) {
            //Create and set up the window.
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(Boolean.TRUE);
            frame.add(container);
            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }

        public static void main(String args[]) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    createAndShowGUI(new JTableTest().panel, "Test");
                }

            });
        }

}