public class Eventhandler implements java.awt.event.ActionListener {

    private Ground ground;

    public Eventhandler(Ground ground) {
        this.ground = ground;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Flower flower = new AFlower();
        ground.add(flow);
    }