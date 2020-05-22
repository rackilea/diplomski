protected void done() {
   populateTextPane();
   SwingUtilities.invokeLater( new Runnable(){
     @Override
     public void run(){
       hideProgressDialog();
       System.out.println("After hideProgressDialog");
     }
   } );
}