Component[] comp = customPanel.getComponents();
for(Component c: comp) {
  if(c is a button i am interested in) {
    c.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           // implement the logic of what happens when button is clicked!
       }
    });
  }
}