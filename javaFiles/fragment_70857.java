class GamePanel extends JPanel {

    Entity e=new Entity;

    @Override
    protected paintComponent(Graphics g) {
        super.paintComponent(g);

        e.draw(g);//call draw method for entity and pass graphics object
    }

}

class Entity {

   //will draw whats necessary to Graphics object
    public void draw(Graphics g) {
        //draw to the graphics object here
    }
}