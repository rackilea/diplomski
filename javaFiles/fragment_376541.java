public class Board2 extends JFrame
{
    static JPanel p1
    static JButton b1
    public Board2(){
        setSize(1000, 800);
        setResizable(false);
        b1 = new JButton("Button");
        p1 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(50,50,20,20);
            }
        }
        p1.add(b1);
        add(p1, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board2();
            }
        });
    }
}