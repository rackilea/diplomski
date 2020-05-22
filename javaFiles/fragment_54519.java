class ToggleButton extends JButton {
    private boolean selected;
    private String otherText;

    public ToggleButton(String text, String otherText) {
        super(text);
        this.otherText = otherText;
        this.setSelected(true);
        this.fixListener();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private void fixListener() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (isSelected()) {
                    setSelected(false);
                    t.start();
                } else {
                    setSelected(true);
                    t.stop();
                }
                String text = getText();
                setText(otherText);
                otherText = text;
            }
        });
    }
}