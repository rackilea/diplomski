JFrame newFrame = new JFrame("New Window");
 b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
           newFrame.pack();
           newFrame.setVisible(true);
     }
 });