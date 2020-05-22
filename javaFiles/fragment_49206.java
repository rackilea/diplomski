public class Images extends JLabel{

    private JLabel heads, tails;

    public Images() {
        heads = new JLabel(new ImageIcon("img/heads.png"));
        tails = new JLabel(new ImageIcon("img/tails.png"));
        add(heads);
        add(tails);
    }
}