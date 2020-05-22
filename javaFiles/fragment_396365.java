public class Start {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        Gui gui = new Gui();
        gui.addBalls();
        f.add(gui);

        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Moving Ball");
        f.setVisible(true);
    }   
}