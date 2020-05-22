private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    jLabel1.setText("Download Started"); 
    SwingWorker sw = new SwingWorker() {
            public Object doInBackground(){
                try {
                    // ...
                    // Do the whole download thing
                } catch (Exception e) {
                    e.printStackTrace();
                }

                jLabel1.setText("Completed");
                return null;
            }
        };
    sw.execute();
}