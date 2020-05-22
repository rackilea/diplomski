private void jButton1ActionPerformed( java.awt.event.ActionEvent evt ){

    jTextField1.setText( "Hello" );
    new javax.swing.SwingWorker< Void, Void >() {

        @Override
        protected Void doInBackground() throws Exception  {
            Thread.sleep( 1000 );
        }

        @Override
        protected void done() {
            jTextField1.setText( "Hello2" );
        }
    }.execute();   
}