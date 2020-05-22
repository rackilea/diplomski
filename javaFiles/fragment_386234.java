@Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics shape = g.create();
        shape.setColor(Color.black);
        shape.fillRect(100,80,100,40);
        shape.setColor(Color.red);
        shape.fillOval(100,80,100,40);
        shape.dispose();// And if you create it, you should dispose it   
    }