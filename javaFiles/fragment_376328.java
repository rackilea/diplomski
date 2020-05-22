public static boolean on_pause() {
    return System.currentTimeMillis() - saved_date > 3 * 60 * 1000;
}

public static void on_resume() {
    saved_date = System.currentTimeMillis();
}