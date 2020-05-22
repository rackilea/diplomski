private static final Object setInterval() {
    String go="go...go...go";
    if (interval == 1)
    {

        timer.cancel();
        return go;
    }
    return --interval;
}