public Pane() {
    ...
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            Point clicked = me.getPoint();
            Rectangle bounds = new Rectangle(172, 62, Exit.getWidth(), Exit.getHeight());
            if (bounds.contains(clicked)) {

                JOptionPane optionPane = new JOptionPane(
                        "The only way to close is\n"
                         + "by pressing one of the following buttons.",
                        JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.YES_NO_OPTION);

            }
        }
    });
    ...
}