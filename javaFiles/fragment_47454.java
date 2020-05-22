Timer timer = new Timer(500, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        ballR.setForeground(Color.WHITE);//or RED, depending
    }
});
timer.setRepeats(false);//don't repeat if you don't want to
timer.start();