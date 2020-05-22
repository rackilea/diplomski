public void actionPerformed(ActionEvent e) {
    if (ww==null || !ww.isVisible()) {
        ww = new Window2();
        ww.setTitle("Window2");
        // You should be using pack
        ww.setSize(600, 400);
    }
    ww.setVisible(true);
}