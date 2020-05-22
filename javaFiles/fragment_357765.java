class Button {
    private ClickHandler onClick;
    public void addClickHandler(ClickHandler clickHandler) {
        onClick = clickHandler;
    }
    public boolean click(Object[] arguments) {
        onClick.click(arguments);
    }
}