private JButton createButton(String text)
{
    JButton button = new JButton(text);
    button.setAlignmentX(JButton.CENTER_ALIGNMENT);
    button.setFocusable(false);

    return button;
}