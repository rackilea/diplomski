final JLabel jLabel2 = new JLabel("HELLO");
jLabel2.setOpaque(true);
jLabel2.setBackground(Color.YELLOW);
jLabel2.setText("Status : Idle");

//perform SSH in a separate thread
Thread sshThread = new Thread(){
    public void run(){
        boolean ok=cpu21.RestartSSH();
        if(ok){
           //update the GUI in the event dispatch thread
           SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   jLabel2.setBackground(Color.GREEN);
                   jLabel2.setText("Status : Run");
               }
           });
        }
    }
};
sshThread.start();