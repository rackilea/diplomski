public Button(int x,int y, int size, JLayeredPane pane )
{
  //The whole premise of have a constructor that declares a JButton inside
  //a JButton doesn't really make any sense, but:
  super();

  JButton b = new JButton();
  pane.add(b, new Integer(0));
  b.setBounds(x,y,size,size);

  b.addActionListener( new ActionListener(){ 

    public void actionPerformed(ActionEvent e){
      System.out.println("Button Clicked");
    }
  }
}