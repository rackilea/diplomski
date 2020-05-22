public class LoadingButton extends RelativeLayout {


    public interface OnLoadingButtonClickListener{
        void onLoadingButtonClickListener();
    }

    private ProgressBar pbTop;
    private ProgressBar pbBottom;
    private Button btnOk;

    private int pbTopProgress = 0;
    private int pbBottomProgress = 0;
    private OnLoadingButtonClickListener mONOnLoadingButtonClickListener;

    public LoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.loading_button, this);

        btnOk = (Button) view.findViewById(R.id.btn_ok);
        pbTop = (ProgressBar) view.findViewById(R.id.pg_top);
        pbBottom = (ProgressBar) view.findViewById(R.id.pg_bottom);

        btnOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mONOnLoadingButtonClickListener != null){
                    mONOnLoadingButtonClickListener.onLoadingButtonClickListener();
                }
            }
        });

    }// LoadingButton

    public void setOnLoadingClickListener(OnLoadingButtonClickListener onLoadingClickListener){
        mONOnLoadingButtonClickListener = onLoadingClickListener;
    }


}