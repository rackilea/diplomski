panel.addMouseListener(new MouseAdapter() {
   @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        label.setLocation(x,y);
        label.setText("(" + x + "," + y + ")");
        label.setSize(label.getPreferredSize());
    }
});