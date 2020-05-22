final JLabel label = new JLabel();
JButton button = new JButton();
button.addActionListener(new ActionListener() {
    public void actioPerformed(ActionEvent ev) {
         Thread workerThread = new Thread() {
               public void run() {
                     //do long running job then update ui
                   SwingUtilities.invokeLater(new Runnable() {
                           public void run(){
                               label.setText("Operation has finished");
                           }
                    });

               }
         }.start();    
    }
});