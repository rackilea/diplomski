public MyButtons(){

    //JFrame frame = new JFrame("MyButtons"); Commentted this
    JPanel panel = new JPanel();
    //frame.add(panel); And this

    JButton b1 = new JButton("Button 1");
    JButton b2 = new JButton("Button 2");

    panel.add(b1);
    panel.add(b2); 
    add(panel); // Add panel to MyButtons frame    
}