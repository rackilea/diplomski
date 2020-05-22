MouseAdapter ma = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }
};
leftButton.addMouseListener(ma);
frame.add(button);