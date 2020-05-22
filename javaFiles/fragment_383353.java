List<Point> originalPoints;
List<point> pointsToDraw;

private int currentIndex = 0;

public DrawingPanel(List<Point> originalPoints) {
    this.originalPoints = originalPoints;
    pointsToDraw = new ArrayList<>();

    Timer timer = new Timer(40, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentIndex == originalPoints.size() - 1) {
                ((Timer)e.getSource()).stop();
            } else {
                pointsToDraw.add(originalPoints.get(currentIndex));
                currentIndex++;
            }
            repaint();
        }
    });
    timer.start();
}