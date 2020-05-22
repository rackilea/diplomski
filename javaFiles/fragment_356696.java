private JPanel panel1;
private JPanel panel2;
private JPanel panel3;

public Demo(String string) {
    // ...

    JPanel topPanel = new JPanel();
    topPanel.setLayout( new BorderLayout() );
    getContentPane().add( topPanel );

    // Create the panels
    panel1 = new MyJPanel1();
    panel2 = new MyJPanel2();
    panel3 = new MyJPanel3();


    // ...
}

private class MyJPanel1 extends JPanel{

    public MyJPanel1(){
        // panel1 = new JPanel();
        setLayout( new BorderLayout() );
        setPreferredSize(new Dimension(200,500));
    }

    @Override 
    public void paintComponent(Graphics g) { 
        //super.paintComponent(g); 

        g.drawString("BLAH1", 20, 20); 
        g.drawRect(200, 200, 200, 200); 
        //setVisible(true);
    } 


}
//.... do the same with the other JPanel classes