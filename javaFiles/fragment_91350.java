class YourMouseListener extends MouseAdapter {
    JLabel label;
    String text;
    YourMouseListener(JLabel label, String text) {
        this.label = label;
        this.text = text;
    }
    // ...
    // use this.label instead of item[i], like this
    public void mouseEntered(MouseEvent entered) {

        label.setText(item_hover_left + " " + text + " " + item_hover_right);
        sound.playSound("menu_hover");

    }
    // ...
}