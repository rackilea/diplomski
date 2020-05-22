private void jbtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                           
    // TODO add your handling code here:
    String itemname = jtxtItemName.getText();
    String category = jcboCategory.getSelectedItem().toString();
    String description = jtxtAreaDescription.getText();
    String reservedPrice = jtxtReservedPrice.getText();
    String image =filename;

    if (itemname.isEmpty() || category.isEmpty() || description.isEmpty() || reservedPrice.isEmpty() || image.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required.");
    }  else {
        Item item = new Item(category, description, reservedPrice, itemname, image);
         try {
             int i = itemdao.createItem(item);
             if(i> 0 ){
                 File sourceFile = new File(path);
                 File destinationFile = new File("resources/Image/"+ filename);
                 BufferedReader reader;
                 PrintWriter writer;
                 try {
                     reader = new BufferedReader(new FileReader(sourceFile));
                     writer = new PrintWriter(new FileWriter(destinationFile));
                     reader.close();
                     writer.close();
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Failed to save Image");
                 }
                 //Paths.get(resource.toURI()).toFile();
                    JOptionPane.showMessageDialog(null, "Successfully saved item");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
}