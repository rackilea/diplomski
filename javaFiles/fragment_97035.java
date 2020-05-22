Timer timer = new Timer(40, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point p = pi.getLocation();
        SwingUtilities.convertPointFromScreen(p, MainFrame.this);
        if (MainFrame.this.getBounds().contains(p)) {
            System.out.println("pi = " + p.x + "x" + p.y);
        }
    }
});
timer.start();