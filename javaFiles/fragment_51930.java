public class MayGame extends Game implements ComponentListener{

    public void componentResized(ComponentEvent e) {}

    public void componentMoved(ComponentEvent e) {
        System.out.println("Window moved!");
        // pause the game somehow
    }

    public void componentShown(ComponentEvent e) {}

    public void componentHidden(ComponentEvent e) {}

}