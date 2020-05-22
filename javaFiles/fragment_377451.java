private Timer timer = null;
private DrawPanel drawPanel = new DrawPanel();  // see below for DrawPanel
public LoginWindow() {
    // add drawPanel somewhere
    ...
    timer = new Timer (50, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            drawPanel.repaint();
        }
    });
    timer.start();
}