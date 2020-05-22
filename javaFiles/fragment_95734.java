private void createDialog(String title) {

    Dialog dialog = new Dialog(title);
    dialog.add("You ended the game.");
    dialog.add("Choose what to do");
    Button stay = new Button("Stay");
    Button newGame = new Button("New Game");
    Button menu = new Button("Menu");

    dialog.add(stay);
    dialog.add(menu);
    dialog.add(newGame);
    dialog.show();

    stay.addActionListener(evt -> {
         dialog.dispose();
    });
}