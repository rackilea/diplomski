private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {    
    String str = "";
    for (int i = 0; i < cdcollection.size(); i++)  {
          str = str + cdcollection.get(i);
    }
    mainTextArea.setText(str);
}