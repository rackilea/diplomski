public class Scale extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final LinearLayout layout;
    ...
    ...
    public Scale(final Context context, ...) {
        super(context);
        ...
        ...
        //Initialise the layout & add a TextView with the emoji in it
        layout = new LinearLayout(context);
        final TextView tv = new TextView(context);
        tv.setText(new String(Character.toChars(0x1F369))); //Doughnut
        layout.addView(tv);
        layout.measure(50, 50);
        layout.layout(0, 0, 50, 50);
    }
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        ...
        ...
        canvas.translate(20, 20); //Translate if necessary
        //Draw the layout on the canvas, draws a doughnut!!
        layout.draw(canvas);
        canvas.save();
        canvas.restore();
    }
}