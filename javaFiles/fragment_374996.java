private void selectActionPerformed(java.awt.event.ActionEvent evt) {                                         

       String id=itemIDlbl.getText();
       String name=itemNamelbl.getText();
        EditInventory ei =new EditInventory();
    ei.get(id,name);
    this.dispose();
    ei.setVisible(true);

    }