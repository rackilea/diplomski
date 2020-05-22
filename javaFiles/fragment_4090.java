private Timer resizeTimer;
//...
// Probably in you classes constructor
resizeTimer = new Timer(250, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        // Actually perform the resizing of the image...
        generateScaledInstance();
    }
});
// Don't want a repeating event...
resizeTimer.setRepeats(false);

//...
public void componentResized(ComponentEvent evt) {
    resizeTimer.restart();
}