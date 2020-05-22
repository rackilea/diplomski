public class JTable_1E  extends JFrame {

    static  int     tableCt = 3;                // nbr of JTables needed
    static  int     WW = 0, CC = 1, EE = 2;     

    static  JTable[]        jTable = new JTable[     tableCt];
    static  JScrollPane[]   jSPane = new JScrollPane[tableCt];

    protected void frameInit() {
        super.frameInit();
        setTitle("_JTable_1E_wRowHdrs");

        setupScrollPanes();                     // a JScrollPane for each custom JTable

        add(jSPane[WW], BorderLayout.WEST);     // add West jSPane to area WEST
        add(jSPane[CC], BorderLayout.CENTER);   // *   Center      to      CENTER
        add(jSPane[EE], BorderLayout.EAST);     // *   East        to      EAST 
        Sop("Added 3 jSPanes to 3 BorderLayout areas\n");
    }

    public static void setupScrollPanes() {
        for (int i = 0;  i < tableCt;  i++) {           // loop 3 times
            jTable[i] = JTab_1E.getJTable();            // get a new JTable     
            Sof2("Got jTable[%d] \n", i, i);            // log action

            jSPane[i] = new JScrollPane(jTable[i]);             // get a new JSPane
            jSPane[i].setRowHeaderView( JTab_1E.rowHeader);     // REQ'D for row headers!
            Sof2("Got jScrollPane[%d] with JTable[%d] \n", i, i);   // log action

            jSPane[i].setMinimumSize(  new Dimension(190, 215));    // get 3 190x214 px 
            jSPane[i].setMaximumSize(  new Dimension(190, 215));    // * rectangles each
            jSPane[i].setPreferredSize(new Dimension(190, 215));    // * containing a JTable
        }
    }   

    public static void main(String[] args) {

        JTable_1E frame = new JTable_1E();              // get JFrame w/ 3 JTables

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void Sop(String output) {
        System.out.println(output);
    }
    public static void Sof2(String fmt, int nbr1, int nbr2) {
        System.out.format(fmt, nbr1, nbr2);
    }   
}