public myFrame(){
okButton=new JButton("OK");
mypanel=new JPanel();
mypanel.setLayout(null);
okButton.setBounds(100, 200, 60, 30);
mypanel.add(okButton);
this.add(mypanel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(500, 400);
setVisible(true);
}