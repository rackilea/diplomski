JPanel thisPanel = this;
a.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
     for(Component c: thisPanel.getComponents()) {
       thisPanel.remove(c);
     }
     JPanel instruction = new Instruction();
     instruction.setBounds(your_values_here...);
     thisPanel.add(instruction);
     thisPanel.revalidate();
     thisPanel.repaint();
}