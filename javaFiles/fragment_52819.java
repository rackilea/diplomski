public class Looseleaf extends JFrame{
    public Looseleaf(){
        this.setSize(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JTextPane txtPane = new JTextPane();
        this.add(new JScrollPane(txtPane)); // <-- Add the text pane to a scroll pane....
        this.setVisible(true);
    }
}