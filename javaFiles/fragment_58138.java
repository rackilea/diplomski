public class FancyTable {

    public static void main(String[] args) {
        new FancyTable();
    }

    public FancyTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable table = new JTable(new LoanModel());
                table.setTableHeader(new SingleColumnTableHeader());
                table.setFillsViewportHeight(true);
                table.setShowHorizontalLines(true);
                table.setShowVerticalLines(false);
                table.setGridColor(Color.LIGHT_GRAY);
                table.setDefaultRenderer(Double.class, new CurrencyRenderer());

                JScrollPane scrollPane = new JScrollPane(table);

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class LoanModel extends AbstractTableModel {

        private List<Loan> loans;

        public LoanModel() {
            loans = new ArrayList<Loan>(25);
            loans.add(new Loan("Davies S.J", 2500000));
            loans.add(new Loan("Lucas M.M", 1700000));
            loans.add(new Loan("Smith R.B", 600000));
            loans.add(new Loan("Jones T.T", 435000));
            loans.add(new Loan("Brown R.B", 600000));
            loans.add(new Loan("Walls T.T", 435000));
            loans.add(new Loan("Healy R.B", 600000));
            loans.add(new Loan("Taylor T.T", 435000));
            loans.add(new Loan("Ginns R.B", 600000));
            loans.add(new Loan("Murphy H", 435000));
        }

        @Override
        public int getRowCount() {
            return loans.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 1:
                    clazz = Double.class;
                    break;
            }
            return clazz;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            Loan loan = loans.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    value = loan.getName();
                    break;
                case 1:
                    value= loan.getAmount();
                    break;
            }
            return value;
        }

    }

    public class Loan {

        private String name;
        private double amount;

        public Loan(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public double getAmount() {
            return amount;
        }

    }

    public class CurrencyRenderer extends DefaultTableCellRenderer {

        private Font boldFont;

        public CurrencyRenderer() {
            setHorizontalAlignment(JLabel.RIGHT);
            boldFont = getFont().deriveFont(Font.BOLD);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if (value instanceof Double) {
                value = NumberFormat.getCurrencyInstance().format(value);
            }

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setFont(boldFont);

            return this;
        }

    }

    public class SingleColumnTableHeader extends JTableHeader {

        private JLabel renderer;

        public SingleColumnTableHeader() {
            setBackground(Color.WHITE);
            renderer = new JLabel("Top Ten Loan Balances");
            renderer.setBorder(new EmptyBorder(4, 0, 4, 0));
        }

        @Override
        public Dimension getPreferredSize() {
            return renderer.getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();

            Insets insets = getInsets();
            int width = getWidth() - (insets.left + insets.right);
            int height = getHeight() - (insets.top + insets.bottom);

            renderer.setBounds(insets.left, insets.top, width, height);
            renderer.paint(g2d);

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(insets.left, insets.top + height - 1, insets.left + width, insets.top + height - 1);

            g2d.dispose();
        }

    }

}