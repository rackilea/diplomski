public static void main(String[] args) {
    JFrame parent = new JFrame();
    parent.setSize(400, 400);
    parent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    parent.setVisible(true);

    Object[] possibilities = { "ham", "spam", "yam" };

    // raw pane
    JOptionPane optionPane = new JOptionPane(
            "Complete the sentence:\n\"Green eggs and...\"",
            JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
            possibilities, possibilities[0]);

    // create a dialog for it with the title
    JDialog dialog = optionPane.createDialog("Customized Dialog");

    // special code - in this case make the cursors match
    dialog.setCursor(parent.getCursor());

    // show it
    dialog.setVisible(true);

    // blocking call, gets the selection
    String s = (String) optionPane.getValue();

    System.out.println("Selected " + s);
}