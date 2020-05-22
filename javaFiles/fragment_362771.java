JavaScript.getCurrent().addFunction("openObj", new JavaScriptFunction() {
    private static final long serialVersionUID = 9167665131183664686L;

    @Override
    public void call(JsonArray arguments) {
        if (arguments.length() != 1) {
            Notification.show("Wrong arguments for openObj: " + arguments.asString());
            return;
        }
        String val = openObject(arguments.get(0).asString());
        JavaScript.getCurrent().execute("myMethod('" + val + "');");
    }
});