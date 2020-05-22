public class r_search_2 extends JFrame implements ActionListener {

    static int counter;
    static String sname = "";
    DefaultTableModel model;
    // String section_name = "";

    JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    JTable table = new JTable(new JTableModel());
    // static JTable table = new JTable();
    String[] columnNames = { "SECTION NAME", "REPORT NAME", "CONTACT", "LINK",
            "METRICS" };
    String from;
    Vector v = new Vector();
    JMenuBar menu = new JMenuBar();

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 60, 25));
    JScrollPane scroll = new JScrollPane(table);

    r_search_2() {

        l1 = new JLabel("Search");
        b1 = new JButton("submit");

        // l0.setBounds(100, 50, 350, 40);
        l1.setBounds(75, 110, 75, 20);
        b1.setBounds(150, 150, 150, 20);

        b1.addActionListener(this);

        topPanel.add(l1, BorderLayout.LINE_START);

        try {

//          File dbFile = new File("executive_db.accdb");
//          String path = dbFile.getAbsolutePath();
//          con = DriverManager
//                  .getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ= "
//                          + path);
//          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//          st = con.createStatement();
//          rs = st.executeQuery("select index_name from Index1");
//          while (rs.next()) {
//              ids = rs.getString(1);
//              v.add(ids);
//
//          }
            v.add("aa");
            v.add("bb");
            c1 = new JComboBox(v);
            c1.setEditable(true);
            c1.setSelectedItem("");
            c1.setBounds(150, 110, 150, 20);

            topPanel.add(c1, BorderLayout.CENTER);
            topPanel.add(b1, BorderLayout.LINE_END);
            mainPanel.add(topPanel, BorderLayout.PAGE_START);

            st.close();
            rs.close();
        } catch (Exception e) {
        }
        // setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            showTableData();
        }
    }

    public void showTableData() {
        // int counter=0;
        model = new DefaultTableModel();

        MouseListener[] M = table.getMouseListeners();
        if(M.length>0)
            for(int i=0;i<M.length;i++)
        table.removeMouseListener(M[i]);

        table.setRowHeight(35);

        JTableHeader th = table.getTableHeader();
        th.setPreferredSize(new Dimension(30, 30));
        th.setFont(th.getFont().deriveFont(Font.BOLD));
        th.setForeground(Color.BLACK);
        th.setBackground(Color.LIGHT_GRAY);

        // DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        scroll
                .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll
                .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        from = (String) c1.getSelectedItem();
        if (from.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a search term",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            TableCellRenderer buttonRenderer = new JTableButtonRenderer();
            table.getColumn("METRICS").setCellRenderer(buttonRenderer);

            table.addMouseListener(new JTableButtonMouseListener(table));
            // static int i=0;
            String section_name = "";
            String report_name = "";
            String contact_name = "";
            String link = "";
            try {

//              pst = con
//                      .prepareStatement("select distinct Section.Section_Name,Report.Report_Name,Report.Link,Contact.Contact_Name "
//                              + "FROM (( Section INNER JOIN Report ON Report.Section_ID=Section.Section_ID ) INNER JOIN Contact ON Contact.Contact_ID=Report.Contact_ID )  LEFT JOIN Metrics ON Metrics.Report_ID=Report.Report_ID  "
//                              + " WHERE Section.Section_Name LIKE '%"
//                              + from
//                              + "%' OR Report.Report_Name LIKE '%"
//                              + from
//                              + "%' OR Metrics.Metric_Name LIKE '%"
//                              + from
//                              + "%' OR Contact.Contact_Name LIKE '%"
//                              + from
//                              + "%' ");
//              ResultSet rs = pst.executeQuery();
                int i = 0;
                //while (rs.next()) {
                    section_name = "Section_Name";
                    report_name = "Report_Name";
                    contact_name = "Contact_Name";
                    link = "Link";
                    // data_values(section_name,report_name,contact_name,link);

                    model.addRow(new Object[] { section_name, report_name,
                            contact_name, link });
                    System.out.println("section name at row" + section_name);
                    /*
                     * s_name(String section_name) {
                     * 
                     * }
                     */
                    sname = section_name;
                    // getsecname(section_name);
                    i++;

            //  }

                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            }

            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        mainPanel.add(scroll);

        mainPanel.revalidate();
        mainPanel.repaint();

    }

    private static class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            // JButton button = (JButton)value;
            JButton button = new JButton("LIST OF METRICS");
            button.setBackground(Color.YELLOW);
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            return button;
        }
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            counter = 0;
            System.out
                    .println("***************************************************************");
            System.out.println("counter value=" + counter++);
            System.out
                    .println("/////////////////////////////////////////////////////////////////////");
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / table.getRowHeight();

            if (row < table.getRowCount() && row >= 0
                    && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                System.out.println("row clicked=" + row);
                System.out.println("column clicked=" + column);
                System.out.println("object value=" + value);
                /*
                 * public void getsecname(String s) { String ss=s; }
                 */

                if (value == null) {
                    Object v = table.getValueAt(row, 0);
                    System.out
                            .println("--------------------------------------------");
                    System.out.println("object value=" + v);
                    String s = v.toString();
                    if (s.equals("Section_Name")) {
                        JOptionPane.showMessageDialog(null, "list of metrics",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                }
            }
        }
    }

    public class JTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        // private static final String[] COLUMN_NAMES = new String[] {"Id",
        // "Stuff", "METRICS"};
        String[] columnNames = { "SECTION NAME", "REPORT NAME", "CONTACT",
                "LINK", "METRICS" };
        private final Class<?>[] COLUMN_TYPES = new Class<?>[] { String.class,
                String.class, String.class, String.class, JButton.class };

        @Override
        public int getColumnCount() {
            // System.out.println("inside getcolumncount");
            // System.out.println(columnNames.length);
            return columnNames.length;

        }

        @Override
        public int getRowCount() {
            // System.out.println("inside getrowcount");
            return 100;
        }

        @Override
        public String getColumnName(int columnIndex) {
            // System.out.println("inside getColumnName");
            // System.out.println("column index="+columnIndex);
            // System.out.println(columnNames[columnIndex]);
            // System.out.println("section name="+section_name);
            return columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            // System.out.println("inside columnIndex");
            // System.out.println(COLUMN_TYPES[columnIndex]);

            return COLUMN_TYPES[columnIndex];
        }

        @Override
        public Object getValueAt(final int rowIndex, final int columnIndex) {
            System.out.println("inside getValueAt");
            switch (columnIndex) {
            case 0:
                return rowIndex;
            case 1: // return "Text for "+rowIndex;
            case 2: // fall through
            case 3:
                final JButton button = new JButton(columnNames[columnIndex]);
                // button.setPreferredSize(new Dimension(100, 100));
                button.setSize(new Dimension(10, 10));
                // System.out.println("halloween");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        JOptionPane.showMessageDialog(JOptionPane
                                .getFrameForComponent(button),
                                "Button clicked for row " + rowIndex);
                    }
                });
                return button;
            default:
                return "";
            }
        }
    }

    /*
     * public String getRowData(int row) { if (model != null) { return
     * section_name; // return row of data from model here } else { // throw
     * some exception } return contact_name; }
     */

    public static void main(String args[]) {

        /*
         * try { for (LookAndFeelInfo info :
         * UIManager.getInstalledLookAndFeels()) {
         * 
         * if ("Nimbus".equals(info.getName())) {
         * UIManager.setLookAndFeel(info.getClassName()); break;
         * 
         * } } } catch (Exception e) { // If Nimbus is not available, you can
         * set the GUI to another look and feel. }
         */

        r_search_2 s = new r_search_2();
        // new r_search_2();
        JFrame fr = new JFrame("Search Executive Reports");
        // fr.add(s.getUI());
        fr.add(s.mainPanel);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocationByPlatform(true);
        fr.setSize(1000, 400);
        // fr.pack();
        fr.setVisible(true);

        // new r_search_2();
    }
}