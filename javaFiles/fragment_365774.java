outText.setText("Wrong!!");
new javax.swing.Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}).start();

// get rid of Thread.sleep()