JOptionPane myInstance ;
if(someCondition is true){
     myInstance = new JOptionPane(ErrorMessage,JOptionPane.ERROR_MESSAGE);
}
else{
    myInstance = new JOptionPane(InformationMessage,JOptionPane.INFORMATION_MESSAGE);
}

JDialog dialog = myInstance.createDialog(parentComponent/* null for new window*/, title);
dialog.show();