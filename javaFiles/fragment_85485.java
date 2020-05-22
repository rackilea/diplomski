//...
        g2.setStroke(new BasicStroke(THICKNESS, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawRect(x + THICKNESS/2, y + THICKNESS/2, width - 2*(THICKNESS/2) - 1, height - 2*(THICKNESS/2) - 1);

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(THICKNESS + THICKNESS/2, THICKNESS + THICKNESS/2, THICKNESS + THICKNESS/2, THICKNESS + THICKNESS/2);
    }
//...