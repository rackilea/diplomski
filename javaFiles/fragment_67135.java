MouseListener ml = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        if(e.getClickCount() == 2) {
             getSomeData(...);
        }
    }
};
tree.addMouseListener(ml);