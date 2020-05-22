//Value to keep track of the last selected text field
public static JTextField lastClicked;
private static javax.swing.JButton jButton1;
private static javax.swing.JTextField jTextField1;
private static javax.swing.JTextField jTextField2;

public static void main(String args[])
{
    //Create and display the form
    java.awt.EventQueue.invokeLater(new Runnable()
    {
        public void run()
        {
            //Setup all the components
            jButton1 = new javax.swing.JButton("Click Me");
            jTextField1 = new javax.swing.JTextField("One");
            jTextField2 = new javax.swing.JTextField("Two");

            //Add listeners
            jButton1.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    //Add a 1 to the last selected text field
                    lastClicked.setText(lastClicked.getText() + "1");
                }
            });

            jTextField1.addFocusListener(new java.awt.event.FocusAdapter()
            {
                public void focusGained(java.awt.event.FocusEvent evt)
                {
                    //change the selected text field to this one
                    lastClicked = (JTextField) evt.getSource();
                }
            });

            jTextField2.addFocusListener(new java.awt.event.FocusAdapter()
            {
                public void focusGained(java.awt.event.FocusEvent evt)
                {
                    //change the selected text field to this one
                    lastClicked = (JTextField) evt.getSource();
                }
            });
        }
    });
}