Louis=new JCheckBox();
Louis.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       LouisClub.setEnabled(((JCheckBox)e.getSource()).isSeleted());
    }
}