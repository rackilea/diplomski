public class MagnitudeTextView extends TextView {

public MagnitudeTextView(Context context) {
    super(context);
    // TODO Auto-generated constructor stub
}

public MagnitudeTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    // TODO Auto-generated constructor stub
}

public MagnitudeTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    // TODO Auto-generated constructor stub
}

/*
 * (non-Javadoc)
 * 
 * @see android.widget.TextView#onDraw(android.graphics.Canvas)
 */
@Override
protected void onDraw(Canvas canvas) {

    int height = getMeasuredHeight();
    int width = getMeasuredWidth();

    int px = width / 2;
    int py = height / 2;

    Paint Red = new Paint(Paint.ANTI_ALIAS_FLAG);
    Red.setColor(Color.RED);

    Paint White = new Paint(Paint.ANTI_ALIAS_FLAG);
    White.setColor(Color.DKGRAY);

    Paint Yellow = new Paint(Paint.ANTI_ALIAS_FLAG);
    Yellow.setARGB(210, 105, 30, 0);

    Paint Blue = new Paint(Paint.ANTI_ALIAS_FLAG);
    Blue.setColor(Color.BLUE);

    float textWidth = Red.measureText(String.valueOf(getText()));

    String g = String.valueOf(getText());
    if (g.startsWith("3") || g.startsWith("4")) {
        canvas.drawText(String.valueOf(getText()), px - textWidth / 2, py,
                White);
    }

    if (g.startsWith("6") || g.startsWith("5") || g.startsWith("7")
            || g.startsWith("8")) {
        canvas.drawText(String.valueOf(getText()), px - textWidth / 2, py,
                Yellow);
    }

    if (g.startsWith("9") || g.startsWith("10")) {
        canvas.drawText(String.valueOf(getText()), px - textWidth / 2, py,
                Red);
    }
    // super.onDraw(canvas);
}