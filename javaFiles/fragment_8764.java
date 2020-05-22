JFrame frame = new JFrame("No Problem");
JPanel panel = new JPanel() {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    };
};
panel.setLayout(new FlowLayout(FlowLayout.CENTER));
JButton button = new JButton("Position Test");
panel.add(button);
frame.add(panel);
frame.pack();
frame.setVisible(true);