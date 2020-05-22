private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
card.show(mainPanel, "homePanel");
welcomeLabel.setText("Benvenuto: " +usernameField.getText().toString());

DefaultListModel<String> dlm = new DefaultListModel<String>();
for(Catalogo p : youing.getCatalogo() ){
 dlm.addElement(p.toString());
}    
JList<String> jList = new JList<String>(dlm);
System.out.println(jList.getModel().toString()); //TO TEST if Jlist successfully added catalogo      
}