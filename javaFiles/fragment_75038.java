public void actionPerformed(ActionEvent event) {

    if(event.getSource()== m_revealBomb){
        m_board.showBombTile();
        yourFrame.repaint();
    }
}