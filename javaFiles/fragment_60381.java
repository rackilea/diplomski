public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity activity;
    public LinearLayout powerOffBtn, flightModeBtn, restartBtn;

    public CustomDialogClass(Activity a) {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        powerOffBtn = (LinearLayout) findViewById(R.id.power_off_btn);
        flightModeBtn = (LinearLayout) findViewById(R.id.flight_mode_btn);
        restartBtn = (LinearLayout) findViewById(R.id.restart_btn);
        powerOffBtn.setOnClickListener(this);
        flightModeBtn.setOnClickListener(this);
        restartBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.power_off_btn:
                //    dismiss();
                break;
            case R.id.flight_mode_btn:
                //    dismiss();
                break;
            case R.id.restart_btn:
                //    dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}