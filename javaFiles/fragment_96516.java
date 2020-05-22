private void setCharComboAction(){
    charCombo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String charName = ((JComboBox)(e.getSource())).getSelectedItem().toString();
                    if (!(charName.equals(guiCharSelDefault[0]))){
                        DefaultComboBoxModel model = new DefaultComboBoxModel(characters);
                        model.setSelectedItem(charName);
                        charCombo.setModel(model);
                    }
                }
            }
    );
}