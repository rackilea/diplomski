private void jStartActionPerformed(java.awt.event.ActionEvent evt) {                                       
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                MyServer ms=new MyServer();
                ms.Show();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
}