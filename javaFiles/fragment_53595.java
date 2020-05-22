Thread thread = new Thread(new Runnable(){
     public void run(){
         //scan
         SwingUtiltilies.invokeLater(new Runnable(){
              //here you can update the the jlabel icon
              public void run(){
                  jlabel.setText("Completed");
              }
         });
     } 
});