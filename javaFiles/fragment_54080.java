private Timer timer;

public DocumentClass(File newImage) {
    ...
    timer = new Timer(75, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    });
}
public void start() {
    timer.start();
}