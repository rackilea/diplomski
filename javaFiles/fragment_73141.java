public class MyJPanel extends JPanel {

    ControlPanel gm = new ControlPanel();
    GameField gf = new GameField();

    public MyJPanel() {
        super();
        setBackground(Color.gray);
        setLayout(new BorderLayout());
        add(gm, "North");
        add(gf, "Center");

        gf.setCp(gm);
        gm.setGf(gf);
    }
}