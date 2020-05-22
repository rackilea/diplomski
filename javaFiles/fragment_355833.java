public static void decorateButton(final AbstractButton button) {
    button.putClientProperty("hideActionText", Boolean.TRUE);
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setBackground(null);
    button.setOpaque(true);
    button.setPreferredSize(BUTTON_SIZE);
    button.setMaximumSize(BUTTON_SIZE);
    button.setMinimumSize(BUTTON_SIZE);
    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            button.setBackground(COLOR_BUTTON_MOUSEOVER);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            button.setBackground(COLOR_BUTTON_PRESSED);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBorder(button.isEnabled() ? BORDER_BUTTON_MOUSEOVER_ENABLED : BORDER_BUTTON_MOUSEOVER_DISABLED);
            button.setBackground(COLOR_BUTTON_MOUSEOVER);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setBackground(null);
        }
    });
}