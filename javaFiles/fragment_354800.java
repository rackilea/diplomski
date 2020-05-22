// Move jTextField1 to print before your print the dynamic JTextBoxes
System.out.println(jTextField1.getText()); 
for (Component spChild : spChildren) {
       if (spChild instanceof JTextField) {
             String text = ((JTextField)spChild).getText();
             System.out.println(text);