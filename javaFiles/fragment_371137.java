public class Test extends JPanel{

private JTable table;
private String COLUMN1 = "COLUMN1";
private String COLUMN2 = "COLUMN2";

public Test() {
    setLayout(new BorderLayout()); 
    table = new LineTable(new Object[][]{{"1", "2"}, {"3", "4"}}, new Object[]{COLUMN1, COLUMN2});

    TableColumn col = table.getColumn(COLUMN1);
    col.setIdentifier(COLUMN1);
    col.setHeaderValue("Column1");

    col = table.getColumn(COLUMN2);
    col.setIdentifier(COLUMN2);
    col.setHeaderValue(new ColorHeaderValue("Column2"));
    col.setHeaderRenderer(new ColorHeaderRenderer());
    col.setCellRenderer(new LineCellRenderer());

    JPanel pn = new JPanel();
    pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));

    pn.add(new JButton(new AbstractAction("Highlight Column2 in red"){

        @Override
        public void actionPerformed(ActionEvent e){
            setColumnColor(COLUMN2, Color.RED);
        }
    }));
    pn.add(new JButton(new AbstractAction("Clear Column2 header color"){

        @Override
        public void actionPerformed(ActionEvent e){
            setColumnColor(COLUMN2, null);
        }
    }));
    pn.add(Box.createHorizontalGlue());
    add(pn, BorderLayout.NORTH);
    add(new JScrollPane(table), BorderLayout.CENTER);
}

private void setColumnColor(final String columnID, final Color cl){
    SwingUtilities.invokeLater(new Runnable(){

        @Override
        public void run(){
            Object headerValue = table.getColumn(columnID).getHeaderValue();
            if(headerValue instanceof ColorHeaderValue){
                ColorHeaderValue clHeaderValue = (ColorHeaderValue) headerValue;
                clHeaderValue.setBrgColor(cl);
                table.getTableHeader().repaint();
            }
        }
    });

}

private static class LineTable extends JTable{

    public LineTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (g != null){
            g.drawLine(0, 0, this.getWidth(), getHeight());
        }

    }
}
private static class LineCellRenderer extends DefaultTableCellRenderer{

    @Override
    protected void paintComponent(Graphics g){            
        super.paintComponent(g);
        if (g != null){
            int halfX = getWidth()/2;
            g.drawLine(halfX, 0, halfX, getHeight());
        }
    }

}
private static class ColorHeaderRenderer extends DefaultTableCellHeaderRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component res = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof ColorHeaderValue){
            ColorHeaderValue headerValue = (ColorHeaderValue) value;
            if (headerValue.getBrgColor() != null){
                setBackground(headerValue.getBrgColor());
            }
        }
        return res;
    }

}
private static class ColorHeaderValue{

    private Color brgColor;
    private String title;

    public ColorHeaderValue(String title) {
        this.title = title;
    }

    public final Color getBrgColor(){
        return brgColor;
    }

    public final void setBrgColor(Color brgColor){
        this.brgColor = brgColor;
    }

    public String toString(){
        return title;
    }

}

public static void main(String[] args){
    JFrame frame = new JFrame("test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add content to the window.
    frame.add(new Test());

    // Display the window.
    frame.pack();
    frame.setSize(300, 200);
    frame.setVisible(true);
}}