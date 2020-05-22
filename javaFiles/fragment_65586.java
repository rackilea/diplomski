public class Control extends LinearLayout
{

    ...

    // add an Activity instance
    private Activity activity;

    // set the Activity in your constructor
    public Control(Context context, AttributeSet attrs, Activity activity)
    {
        super(context, attrs);
        this.activity = activity;
    }

    @Override
    protected void onFinishInflate()
    {
        ...

           // Use the instance activity here
           activity.showDialog(2);
        ...
    }
}