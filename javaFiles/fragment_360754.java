public class FFListenerButton extends FFButton
{
    private FFListener ffListener;

    public FFListenerButton(Rectangle bounds, CharSequence text, FFListener ffListener)
    {
        super(bounds, text);
        this.ffListener = ffListener;
    }

    @Override
    protected void action()
    {
        ffListener.onClick(this);
    }
}