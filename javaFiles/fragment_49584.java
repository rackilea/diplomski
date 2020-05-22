public class Screen extends JFrame {

    private Kingdomcraft kd;
    private MainMenu mm;
    private Dimension min = new Dimension(800, 600);
    private ImageIcon img;

    public Screen(Kingdomcraft kingdomcraft) {
        kd = kingdomcraft;

        mm = new MainMenu(this);
        //...
    }

    public Kingdomcraft getKingdomcraft() {
        return kd;
    }