// This is the code where you have create JPanel object
JPanel jPanel = new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try{
            int c=Integer.parseInt(jTextField1.getText());//read the value

            g.setColor(Color.red);
            g.fillOval(100, 50, c, c);
            g.fillOval(400, 50, c, c);

        }catch(NumberFormatException e){//handle the exception} 
    }
};


private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {  

    try{
        jLabel6.setText("");
        jPanel.repaint(); // simply call repaint method
    }catch(NumberFormatException e){
        jLabel6.setText("Incorrect data");
    }
}