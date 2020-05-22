b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        boolean start = true;
        if (start == true){
            timer.start();
            b1.setText("stop");
            start = false;
        } else if (start == false){
            timer.stop(); //the part that doesn't work
            b1.setText("start");
            start = true;
        }
    }
});