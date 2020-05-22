Button b = new Button();

// java 7
b.addClickHandler(new ClickHandler() {
    @Override
    public boolean click(Object[] argument) {
        Log.i("a", "button0");
        return true;
    }
});

// java 8
b.addClickHandler(args -> {
    Log.i("a", "button0");
    return true;
});