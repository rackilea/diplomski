public class ProgressBarPreference extends Preference {


    public ProgressBarPreference(Context context) {
        super(context);
    }
    public ProgressBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressBarPreference(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
    }

    private ProgressBar mProgressBar;
    private TextView mLabel;
    private int lastReqProgress=-1;
    private int lastReqMax=-1;
    private String lastLabel;

    @Override
    protected View onCreateView(ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) Manager.appcontext.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View myLayout=li.inflate(R.layout.progressbarpreference, null, false);
                ((ViewGroup)myLayout.findViewById(R.id.preference_super_container)).addView(super.onCreateView(parent));
        mProgressBar=(ProgressBar) myLayout.findViewById(R.id.preference_progress_bar);
        mLabel=(TextView) myLayout.findViewById(R.id.preference_progress_label);
        if (lastReqProgress>-1){
            mProgressBar.setProgress(lastReqProgress);
        }
        if (lastReqMax>-1){
            mProgressBar.setMax(lastReqMax);
        }
        if (lastLabel!=null){
            mLabel.setText(lastLabel);
        }

        return myLayout;
    }


    public void setProgress(int value){
        if (mProgressBar!=null){
            mProgressBar.setProgress(value);
        } else {
            lastReqProgress=value;
        }

    }

    public void setMax(int value){
        if (mProgressBar!=null){
            int savedprogress=mProgressBar.getProgress();
            mProgressBar.setMax(0);
            mProgressBar.setMax(value);
            mProgressBar.setProgress(savedprogress);
        } else {
            lastReqMax=value;
        }

    }


    public void setLabel(String text){
        if (lastLabel!=null){
            mLabel.setText(text);
        } else {
            lastLabel=text;
        }
    }



}