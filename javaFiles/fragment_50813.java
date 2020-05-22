private void jStartActionPerformed(java.awt.event.ActionEvent evt) {                                       
    MyServer ms=new MyServer();
    try {
        ms.Show();
    } catch (IOException ex) {
        System.out.println(ex);
    }
}