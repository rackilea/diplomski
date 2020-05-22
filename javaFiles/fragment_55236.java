Button b = new Button("submit", new Button.ClickListener() {
    @Override
    public void buttonClick(ClickEvent event) {
        // handle your event
    }
});
layout.addComponent(b);
b.setClickShortcut(KeyCode.ENTER);