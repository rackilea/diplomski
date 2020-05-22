private JLabel scoreLabel = new JLabel("Score: " + score);
private int score = 0;

public Gamevenster() {
    scoreLabel.setFont(new Font("impact", Font.PLAIN, 30));
    scoreLabel.setForeground(Color.WHITE);
    add(scoreLabel);

    addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            int clickX = (int)p.getX();
            int clickY = (int)p.getY();

            if(clickX > x && clickX < x + 100 && clickY > y && clickY  < y + 100) {
                score++;
                scoreLabel.setText("Score: " + score);
            }
        }
    });
}