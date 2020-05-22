Timer t = new Timer(10, new AbstractAction() {
    int count = 20;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (count < 1000) {
            //increment rectangles y position
            //now repaint container so we can see changes in co-ordinates (unless you have a timer which repaints for you too)
            count++;
        } else {//counter is at 1000 stop the timer
            ((Timer) ae.getSource()).stop();
        }
    }
});
t.start();