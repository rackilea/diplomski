JDialog dialog = new JDialog(Main.getMainFrame(), true);
ProgressBarJPanel progressBarJPanel = new ProgressBarJPanel();
dialog.setContentPane(progressBarJPanel);
dialog.pack();
dialog.setVisible(true);
Runnable r = new Runnable(){
      public void run(){
                //this is the long running job
                while ((val = bufferedInputStream.read()) != -1)
                {
                    fileOutputStream.write(val);
                }
                //here is the callback to UI thread
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        progressBarJPanel.end();
                        dialog.setVisible(false);
                    }
               }
      };
Thread t = new Thread(r);
t.start();