public class CustomView extends View {
public CustomView(Context context) {
    super(context);
}

public CustomView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
}

final Paint m_paint = new Paint();
public String m_Text = "Button";
private final Rect textBounds = new Rect();
public Typeface m_TypeFace = Typeface.create("Arial",Typeface.NORMAL);
public int m_TextColor = Color.argb(255, 0, 0, 0);
public int m_TextSize = 32;
private final Paint textPaint = new Paint();

@Override
protected void onDraw(Canvas canvas) {

    Rect m_Bounds = new Rect(100,100,500,200);
    boolean DO_PAINT = true;
    boolean DO_GRADIENT = true;


    if ( DO_PAINT) {
        m_paint.setStyle(Paint.Style.FILL);
        m_paint.setColor(Color.GREEN);
        canvas.drawRect(m_Bounds, m_paint);
    }

    if (DO_GRADIENT) {
        m_paint.setShader(new LinearGradient(0, m_Bounds.top, 0, m_Bounds.bottom, Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));
        canvas.drawRect(m_Bounds.left, m_Bounds.top, m_Bounds.right, m_Bounds.bottom, m_paint);
    }

    m_paint.setColor(m_TextColor);
    m_paint.setTextSize(m_TextSize);
    m_paint.setTypeface(m_TypeFace);

    m_paint.getTextBounds(m_Text, 0, m_Text.length(), textBounds);

    double x = m_Bounds.left + m_Bounds.width()/2  - textBounds.exactCenterX();
    double y = m_Bounds.top  + m_Bounds.height()/2 - textBounds.exactCenterY();

    textPaint.setColor(m_TextColor);
    textPaint.setTextSize(m_TextSize);
    textPaint.setTypeface(m_TypeFace);
    canvas.drawText(m_Text, (float) x, (float) y, textPaint);

}