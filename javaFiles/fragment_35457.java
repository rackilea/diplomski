for(int i = 0;i<1000;i++){
    panel.add(new paintComponent());
    panel.setBackground(Color.black);
    frame.repaint();
    try {
        Thread.sleep(80);
    } catch (InterruptedException e1){e1.printStackTrace();}
}