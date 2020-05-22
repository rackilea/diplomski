public static void main(String args[]){
    final main main = new main();
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        initComponents(main);
      }
    });
  }