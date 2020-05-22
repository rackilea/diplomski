pause.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        elapsed += now;
        swTimer.stop();
    }
});