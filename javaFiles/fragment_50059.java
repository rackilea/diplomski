mPlayerLastRollLabel.setText("Player rolled: ...");
Timer t = new Timer(5000, new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        mPlayerLastRollLabel.setText("Player rolled: " + mFaceNumber);
    }
});
t.setRepeats(false);
t.start();