class AngleSlider implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();

        double dAngle = (double)source.getValue();
        pnlCannon.dCannonAngle=Math.toRadians(dAngle);
        pnlCannon.repaint();
    }
}