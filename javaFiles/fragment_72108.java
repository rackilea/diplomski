public class SimpleEditText extends EditText
{
    private static float textSize=14.0;

    public SimpleEditText(Context context)
    {
        super(context);
        this.setTextSize(textSize);
    }

    public SimpleEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.setTextSize(textSize);
    }

    public SimpleEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.setTextSize(textSize);
    }
}