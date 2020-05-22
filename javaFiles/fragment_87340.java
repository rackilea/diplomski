public class ColorTextView extends TextView {

    private static int color = Color.BLUE;

    public ColorTextView(Context context) {
        super(context);
        this.setTextColor(color)
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTextColor(color)
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTextColor(color)
    }

    public static void setGlobalColor(int newcolor) {
        color = newcolor;
    }
}