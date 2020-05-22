public class CustomAutoCompleteTextView extends AutoCompleteTextView {


    //was the text just cleared?
    boolean justCleared = false;


    public Drawable imgClearIcon = getResources().getDrawable(android.R.drawable.ic_menu_close_clear_cancel);

    public CustomAutoCompleteTextView(Context context) {
        super(context);

        init();
    }

    /* Required methods, not used in this implementation */
    public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
    }
    /* Required methods, not used in this implementation */
    public CustomAutoCompleteTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }


    void init()
    {
        // Set the bounds of the button
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, imgClearIcon, null);

        // button should be hidden on first draw
        clrButtonHandler();

        //if the clear button is pressed, clear it. Otherwise do nothing
        this.setOnTouchListener(new OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                CustomAutoCompleteTextView et = CustomAutoCompleteTextView.this;

                if (et.getCompoundDrawables()[2] == null)
                    return false;

                if (event.getAction() != MotionEvent.ACTION_UP)
                    return false;

                if (event.getX() > et.getWidth() - et.getPaddingRight() - imgClearIcon.getIntrinsicWidth())
                {
                    et.setText("");
                    CustomAutoCompleteTextView.this.clrButtonHandler();
                    justCleared = true;
                }
                return false;
            }
        });
    }

    void clrButtonHandler()
    {

        if (this == null || this.getText().toString().equals("") || this.getText().toString().length() == 0)
        {
            //Log.d("CLRBUTTON", "=cleared");
            //remove clear button
            this.setCompoundDrawables(null, null, null, null);
        }
        else
        {
            //Log.d("CLRBUTTON", "=not_clear");
            //add clear button
            this.setCompoundDrawablesWithIntrinsicBounds(null, null, imgClearIcon, null);
        }
    }
}