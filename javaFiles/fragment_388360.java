public void paintComponent(Graphics g){
    super.paintComponent(g);
    if (!defeat){
        square.display(g);
        wall.display(g);
        for (Circle circle: circleArray){

            circle.display(g);
        }

    }else if(defeat){

        g.drawString("You have been defeated", 300, 300);
    }