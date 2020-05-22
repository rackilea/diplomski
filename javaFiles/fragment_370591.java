public class TheraGUI extends JFrame {
    public TheraGUI(){
        Board board = new Board();
        this.setLayout(new GridBagLayout());
        this.setTitle("Thera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // note the order
        this.add(board);
        this.pack();
        this.setVisible(true);
    }
}