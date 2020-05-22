package sample.package.name;

public class ColoredPaddingView extends View {
    Rect rect = new Rect();

    // Constructors omitted. Override them all and call the super constructor

    @Override
    public void onDraw(Canvas canvas) {
        int l = getPaddingLeft();
        int t = getPaddingTop();
        int r = getWidth() - getPaddingRight();
        int b = getHeight() - getPaddingBottom();
        rect.set(l, t, r, b);

        canvas.save();
        canvas.clipRect(rect, Region.Op.DIFFERENCE);
        canvas.drawColor(Color.RED); // or some other color
        canvas.restore;

        super.onDraw(canvas);
    }
}