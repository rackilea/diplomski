final JPopupMenu menu = new JPopupMenu();
menu.add(new JCheckBoxMenuItem("Other Court"));
menu.add(new JCheckBoxMenuItem("Tribunal Court"));
menu.add(new JCheckBoxMenuItem("High Court"));
menu.add(new JCheckBoxMenuItem("Supreme Court"));

final JButton button = new JButton();
button.setAction(new AbstractAction("Court") {
    @Override
    public void actionPerformed(ActionEvent e) {
        menu.show(button, 0, button.getHeight());
    }
});

JFrame frame = new JFrame();
frame.getContentPane().add(button);
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);