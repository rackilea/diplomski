public class CustomView1 extends RelativeLayout {

    public CustomView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lcd_layout, this, true);

        TextView part1 = (TextView) findViewById(R.id.the_id);
        //other stuff
    }

    public CustomView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);        
    }

    public CustomView1(Context context) {
        this(context, null);        
    }

}