//In your RotationPanel class
private final Timer timer = new Timer(20, new TimerListener());
public void rotate(){
    timer.start();
}
private void setFrame(int j) {
    //Copied from old rotate method
    o.x =(a*0.5)*Math.sin(Math.PI*j/180);
    ... //13 more lines
}
private class TimerListener implements ActionListener{
    private int frame = 0;

    public void actionPerformed(ActionEvent e){
        RotationPanel.this.setFrame(++frame);
        RotationPanel.this.repaint();
        if(frame == 180) {
            frame = 0;
            timer.stop();
        }
    }
}