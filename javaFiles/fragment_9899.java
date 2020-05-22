public void addComponentToPane(Container pane) {

    JPanel card1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    …
    pane.add(new JPanel() {
        @Override // placeholder for actual content
        public Dimension getPreferredSize() {
            return new Dimension(800, 200);
        }
    }, BorderLayout.CENTER);
    pane.add(cards, BorderLayout.PAGE_END);
}