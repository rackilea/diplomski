S1L1Reset.setUI(new BasicButtonUI() {
        @Override
        public void update(Graphics g, JComponent c) {
            if (c.isOpaque()) {
                Color fillColor = c.getBackground();

                AbstractButton button = (AbstractButton) c;
                ButtonModel model = button.getModel();

                if (model.isPressed()) {
                    fillColor = fillColor.darker();
                } else if (model.isRollover()) {
                    fillColor = fillColor.brighter();
                }

                g.setColor(fillColor);
                g.fillRoundRect(0, 0, c.getWidth(),c.getHeight(), 20, 20);
            }
            paint(g, c);
        }
    });