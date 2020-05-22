public void paintComponent(Graphics g) {

   //This solved the problem
    super.paintComponent(g);



    g.setColor(Color.magenta);
    if (wdice.getValue() == 0) {
        g.drawRect(0, 0, 100, 100);


    } else if (wdice.getValue() == 1) {
        g.fillOval(40, 40, 15, 15);

    } else if (wdice.getValue() == 2) {
        g.fillOval(75, 10, 15, 15);
        g.fillOval(10, 75, 15, 15);
    } else if (wdice.getValue() == 3) {
        g.fillOval(75, 10, 15, 15);
        g.fillOval(40, 40, 15, 15);
        g.fillOval(10, 75, 15, 15);
    } else if (wdice.getValue() == 4) {
        g.fillOval(75, 10, 15, 15);
        g.fillOval(10, 75, 15, 15);
        g.fillOval(10, 10, 15, 15);
        g.fillOval(75, 75, 15, 15);
    } else if (wdice.getValue() == 5) {
        g.fillOval(75, 10, 15, 15);
        g.fillOval(10, 75, 15, 15);
        g.fillOval(10, 10, 15, 15);
        g.fillOval(75, 75, 15, 15);
        g.fillOval(40, 40, 15, 15);

    } else if (wdice.getValue() == 6) {
        g.fillOval(10, 10, 15, 15);
        g.fillOval(10, 75, 15, 15);
        g.fillOval(75, 10, 15, 15);
        g.fillOval(75, 75, 15, 15);
        g.fillOval(10, 40, 15, 15);
        g.fillOval(75, 40, 15, 15);

    }