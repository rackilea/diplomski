private JPanel panel1;
private JPanel panel2;
private JPanel panel3;

public Demo(String string) {
    // ...

    JPanel topPanel = new JPanel();
    topPanel.setLayout( new BorderLayout() );
    getContentPane().add( topPanel );

    // Create the panels
    new MyJPanel1();
    new MyJPanel2();
    new MyJPanel3();


    // ...
}

private class MyJPanel1 extends JPanel{

    public MyJPanel1(){
        panel1 = new JPanel();
        panel1.setLayout( new BorderLayout() );
        panel1.setPreferredSize(new Dimension(200,500));
    }

    @Override 
    public void paintComponent(Graphics g) { 
        //super.paintComponent(g); 

        g.drawString("BLAH1", 20, 20); 
        g.drawRect(200, 200, 200, 200); 
        //setVisible(true);
    } 


}
//.... etc