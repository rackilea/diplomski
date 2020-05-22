button.addMouseListener(new MouseAdapter() {// MouseAdapter is empty implementation
                                            // of MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        if (!b.isEnabled())
            System.out.println("you cannot click me again");
    }
});