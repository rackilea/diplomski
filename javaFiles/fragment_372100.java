private JButton createButton(String tooltip, int width, int height, Color color){

        JButton button = new JButton();
        button.setToolTipText(tooltip);
        button.setPreferredSize(new Dimension(width,height));
        button.setBackground(color);
        button.setOpaque(true);

        return button;
    }