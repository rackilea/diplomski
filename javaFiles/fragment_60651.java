startGame.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        gameActive = true;
        add(game);
        revalidate();
        repaint();
    }
});