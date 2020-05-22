public RoadNetwork() {

    Timer timer = new Timer(50, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            // do something with image positions like loop through an array to move coordinates
            repaint();
        }
    });
    timer.start();
}