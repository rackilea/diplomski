public class TableGrid extends JPanel {

    private DecimalFormat df;
    private MaskFormatter mf;
    private JFormattedTextField tf;

    public TableGrid() {
        df = new DecimalFormat("0.00");
        try {
            mf = new MaskFormatter("#.##");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        tf = new JFormattedTextField(mf);
        TableModel dataModel = new TableModel();
        JTable table = new JTable(dataModel);
        table.setCellSelectionEnabled(true);
        table.setRowHeight(32);
        table.setDefaultRenderer(BigDecimal.class, new DecRenderer(df));
        table.setDefaultEditor(BigDecimal.class, new DecEditor(tf, df));
        this.add(table);
    }

    private static class TableModel extends AbstractTableModel {

        private static final int SIZE = 4;
        private BigDecimal[][] matrix = new BigDecimal[SIZE][SIZE];

        public TableModel() {
            for (Object[] row : matrix) {
                Arrays.fill(row, BigDecimal.valueOf(0));
            }
        }

        @Override
        public int getRowCount() {
            return SIZE;
        }

        @Override
        public int getColumnCount() {
            return SIZE;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return matrix[row][col];
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            matrix[row][col] = (BigDecimal) value;
        }

        @Override
        public Class<?> getColumnClass(int col) {
            return BigDecimal.class;
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return true;
        }
    }

    private static class DecRenderer extends DefaultTableCellRenderer {

        DecimalFormat df;

        public DecRenderer(DecimalFormat df) {
            this.df = df;
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setBackground(Color.lightGray);
            this.df.setParseBigDecimal(true);
        }

        @Override
        protected void setValue(Object value) {
            setText((value == null) ? "" : df.format(value));
        }
    }

    private static class DecEditor extends DefaultCellEditor {

        private JFormattedTextField tf;
        private DecimalFormat df;

        public DecEditor(JFormattedTextField tf, DecimalFormat df) {
            super(tf);
            this.tf = tf;
            this.df = df;
            tf.setHorizontalAlignment(JFormattedTextField.CENTER);
        }

        @Override
        public Object getCellEditorValue() {
            try {
                return new BigDecimal(tf.getText());
            } catch (NumberFormatException e) {
                return BigDecimal.valueOf(0);
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
            tf.setText((value == null) ? "" : df.format((BigDecimal) value));
            if (isSelected) tf.selectAll();
            return tf;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("TableGrid");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new TableGrid());
                f.pack();
                f.setVisible(true);
            }
        });
    }
}