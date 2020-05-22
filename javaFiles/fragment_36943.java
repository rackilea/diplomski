Button button = new Button();

button.addClickListener(new Button.ClickListener() {
    private static final long serialVersionUID = 1L;

    @Override
    public void buttonClick(final ClickEvent event) {
        System.out.println("Click!");
    }
});

button.setClickShortcut(ShortcutAction.KeyCode.TAB);

button.click();