new JToggleButton().addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
        JToggleButton tBtn = (JToggleButton)e.getSource();
        if (tBtn.isSelected()) {
           System.out.println("button selected");
        } else {
           System.out.println("button not selected");
        }        
  }
});