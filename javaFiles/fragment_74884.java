private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    String qty=jTextField2.getText();

    try {
        int q=Integer.parseInt(qty);
        if(q!=0) {
            jTextField1.setVisible(true);
        }
    } catch (NumberFormatException ex) {
        // you know it can't be 0 if it got here
        jTextField1.setVisible(true);
    }