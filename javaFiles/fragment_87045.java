// move it outside of class Key
    private class Listener implements ActionListener {
        private Listener() {}

        public void actionPerformed(ActionEvent e) {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, 400, 400);

            ball.move(400.0, 400.0);
            collide(ball, prize);

            ball.draw(myBuffer);
            prize.draw(myBuffer);

            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font("Monospaced", 1, 24));
            myBuffer.drawString("Count: " + hits, 250, 25);
            repaint();
        }
    }

    private class Key extends KeyAdapter {