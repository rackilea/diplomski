final JComboBox genderComboBox = null;
final JComboBox itemComboBox = null;

final DefaultComboBoxModel hisModel = new DefaultComboBoxModel(new String[]{"a", "b", "c"});
final DefaultComboBoxModel herModel = new DefaultComboBoxModel(new String[]{"x", "y", "z"});

genderComboBox.addActionListener (new ActionListener () {
    public void actionPerformed(ActionEvent e) {
        if ("Men".equals(genderComboBox.getSelectedItem())){
            itemComboBox.setModel(hisModel);    
        } else {
            itemComboBox.setModel(herModel);    
        }
    }
});