public class Scale extends View {
    private final TextPaint tPaint = new TextPaint();
    private final StaticLayout lsLayout;
    ...
    ...
    public Scale(final Context context, ...) {
        super(context);
        ...
        ...
        //Initialise the layout & add a TextView with the emoji in it
        String emoji = new String(Character.toChars(0x1F369))); //Doughnut
        lsLayout = new StaticLayout(emoji, tPaint, 80, Layout.Alignment.ALIGN_CENTER, 1, 1, true);
    }
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        ...
        ...
        canvas.translate(20, 20); //Translate if necessary
        //Draw the layout on the canvas, draws a doughnut as bright as the rest of the canvas!!
        lsLayout.draw(canvas);
        canvas.save();
        canvas.restore();
    }
}