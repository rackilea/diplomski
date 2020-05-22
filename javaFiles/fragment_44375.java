for (int i=0; i < nekopics.length; i++) {
    timer = new Timer(1000, this);
    timer.setInitialDelay(0);
    timer.start();
    currentimg = nekopics[i];
    repaint();
}