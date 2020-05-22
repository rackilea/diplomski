ActionListener listener = new ActionListener(){
    public void actionPerformed(ActionEvent event){
        gsm.setState(3);
    }
};
Timer timer = new Timer(2000, listener);
timer.setRepeats(false);
timer.start();