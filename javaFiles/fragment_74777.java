Timer timer = new Timer(100, new ActionListener(){   // causes an action every 100 millis
    public void actionPerformed(ActionEvent e){
        // change the xLocation and yLocation of each car
        car1.xLocation += 5;
        car1.yLocation += 5;
        car2.xLocation += 5;
        car2.yLocation += 5;
        car3.xLocation += 5;
        car3.yLocation += 5;

        repaint();
    }
});
timer.start();