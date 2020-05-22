@Override
public void show() {
    final TextFieldStyle fieldStyle = new TextFieldStyle(new BitmapFont(), Color.WHITE, null, null, null);
    textField = new TextField("path", fieldStyle);
    final TextButtonStyle buttonStyle = new TextButtonStyle();
    buttonStyle.font = new BitmapFont();
    buttonStyle.fontColor = Color.WHITE;
    buttonStyle.pressedOffsetY = 1f;
    buttonStyle.downFontColor = new Color(0.8f, 0.8f, 0.8f, 1f);
    button = new TextButton("Übernehmen", buttonStyle);
    button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (textField.getText() != "" && textField.getText() != "path") {
                texture = new Texture(textField.getText());
                game.setScreen(new Workscreen(texture));
            }
        }
    });


    table.row();
    table.add(textField);
    table.add(button);

    // Make the table fill the stage.
    table.setFillParent(true);

    stage.addActor(table);
}