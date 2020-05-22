component.addShortcutListener(new ShortcutListener("caption", KeyCode.ENTER, null) {

    private static final long serialVersionUID = 1L;

    @Override
    public void handleAction(Object sender, Object target) {
        label.setValue("entered");
    }
});