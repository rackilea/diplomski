public class MessageButton extends ImageButton {

    private String number;

    public MessageButton(Context context) {
        this(context, null);
    }

    public MessageButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs.getAttributeValue("uk.co.gsteinert.ssbb", "number") != null) {
            this.number = attrs.getAttributeValue("uk.co.gsteinert.ssbb", "number");
        }
    }
}