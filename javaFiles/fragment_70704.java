class MyView extends View {

    @Override
    protected void onDraw(Canvas canvas) {
        Time t = new Time();
        t.setToNow();
        long timeStart = t.toMillis(false);

        super.onDraw(canvas);

        t.setToNow();
        long timeToDraw = t.toMillis(false) - timeStart;

    }
}