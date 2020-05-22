class Move extends JPanel {
    static int x = 80, cv = 0;

    Move(){
        setVisible(false); <-- Make it false here
    }

    public void move() {
        this.setVisible(true);     <----- make it visible here when you click start
        repaint();
    }

    public void paintComponent(Graphics g) {
        setBackground(Color.green);
         ..... REMAINING CODE
    }
}