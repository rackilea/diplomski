public void actionPerformed(ActionEvent event) {
    cards.setCellRenderer(new ItemRenderer(cardsPane));
    repaint();
    if(animation.done){
        timer.stop()
    }
}