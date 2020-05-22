DC.addActionListener(
        new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        DrawCirc circ = new DrawCirc();
        add(circ);
        revalidate();
        repaint();
    }
});