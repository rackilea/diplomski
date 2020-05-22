private int i = 0;
private Timer tmr = new Timer(2000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(" .");
        ++i;
        if(i >= 2)
           tmr.stop();
    }
});