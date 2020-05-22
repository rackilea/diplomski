public enum Color {

    RED(text -> new RedColor(text));
    BLUE(text -> new BlueColor(text));

    Function<String, Color> function;

    Color(Function function) {
        this.function = function;
    }

    Color getColor(String text) {
        return function.apply(text);
    }
}