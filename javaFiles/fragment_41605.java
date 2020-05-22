public Button(String text) {
    super(text);
    setFont(new Font(null, Font.BOLD, 30));
    setText(text);
    addMouseListener(this);
}