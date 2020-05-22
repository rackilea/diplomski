boolean sthap = false;

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            while (!sthap) {
                System.out.println("run");
            }
        }
    }).start();
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    sthap = true;
}