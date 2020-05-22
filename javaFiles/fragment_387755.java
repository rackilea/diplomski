Thread t = new Thread(new Runnable(){
        public void run(){
            JOptionPane.showMessageDialog(null, "Hello");
        }
    });
  t.start();