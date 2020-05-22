private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // TODO add your handling code here:
    String sql = "INSERT INTO tbStudent VALUES ('"+txtNIS.getText()+"','"+txtName.getText()+"','"+txtAddress.getText()+"','"+txtEmail.getText()+"','"+txtJurusan.getText()+"')";
    java.sql.Connection conn=(Connection)connection.configDB();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
    SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
        private String message;
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                return pst.execute();
            } catch (Exception e) {
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void done() {
            if (get()) {
                JOptionPane.showMessageDialog(null, "Sukses menambahkan data");
            } else {
                JOptionPane.showMessageDialog(menu.this, message);
            }
        }

    };
    worker.execute();
}