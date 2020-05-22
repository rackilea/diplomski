@Override
public void timingEvent(float fraction) {
    translateY = (int) (MAX_Y * fraction);
    repaint();
}     

@Override
public void end() {
    mainGUI.initiateSwitchToMainScreenTransition();
}