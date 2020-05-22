class CStyleDocument extends DefaultStyledDocument
{
    private  Style primaryStyle;

    public CStyleDocument() {
        super();
         primaryStyle = this.addStyle("Primary", null);
    }
    public Style getAttrStyle()
    {
        return primaryStyle;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str, primaryStyle); 

    }

}

public class JTextPaneTest extends javax.swing.JFrame {

    CStyleDocument styleDocument;

    public JTextPaneTest() {
        initComponents();

        styleDocument = new CStyleDocument();
        jTextPane1.setDocument(styleDocument);

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        boldSelButton = new javax.swing.JToggleButton();
        ulSelButton = new javax.swing.JToggleButton();
        strkSelButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));

        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        boldSelButton.setText("Bold");
        boldSelButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                boldSelButtonStateChanged(evt);
            }
        });
        jPanel1.add(boldSelButton);

        ulSelButton.setText("Under Lined");
        ulSelButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ulSelButtonStateChanged(evt);
            }
        });
        jPanel1.add(ulSelButton);

        strkSelButton.setText("Strike Through");
        strkSelButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                strkSelButtonStateChanged(evt);
            }
        });
        jPanel1.add(strkSelButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>                        

    private void boldSelButtonStateChanged(javax.swing.event.ChangeEvent evt) {                                           
             StyleConstants.setBold(styleDocument.getAttrStyle(), ((JToggleButton)evt.getSource()).isSelected());
             jTextPane1.requestFocus();




    }                                          

    private void ulSelButtonStateChanged(javax.swing.event.ChangeEvent evt) {                                         
        StyleConstants.setUnderline(styleDocument.getAttrStyle(), ((JToggleButton)evt.getSource()).isSelected());
        jTextPane1.requestFocus();
    }                                        

    private void strkSelButtonStateChanged(javax.swing.event.ChangeEvent evt) {                                           
       StyleConstants.setStrikeThrough(styleDocument.getAttrStyle(), ((JToggleButton)evt.getSource()).isSelected());
       jTextPane1.requestFocus();
    }                                          


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JTextPaneTest();
                frame.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton boldSelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton strkSelButton;
    private javax.swing.JToggleButton ulSelButton;
    // End of variables declaration                   
}