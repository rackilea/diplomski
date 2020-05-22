public boolean intersects(JLabel testa, JLabel testb){
    Rectangle rectB = testb.getBounds();

    Rectangle result = SwingUtilities.computeIntersection(testa.getX(), testa.getY(), testa.getWidth(), testa.getHeight(), rectB);

    return (result.getWidth() > 0 && result.getHeight() > 0);
}