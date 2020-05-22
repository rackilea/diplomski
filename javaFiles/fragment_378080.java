frame = new JFrame();
frame.addComponentListener(new ComponentListener() {
    @Override
    public void componentResized(ComponentEvent e) {
        // frame.repaint();
        ChartPanel cp = (ChartPanel)panel.getComponents()[0];
        cp.setPreferredSize(new java.awt.Dimension(panel.getWidth(), panel.getHeight()));
        cp.setSize(new java.awt.Dimension(panel.getWidth(), panel.getHeight()));
        // frame.invalidate();
        frame.validate();
        // frame.repaint();
    }
    ...
});
...