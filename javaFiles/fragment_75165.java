private class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PieceButton pb = (PieceButton) e.getSource();
        icon.color = pb.piece.color;
        label.repaint();
        model.check(pb.piece);
    }
}