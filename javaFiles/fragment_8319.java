public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    boolean flag =false;
    PopupWindow popupWindow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }
    public void init() {
        Button btn_show = (Button) findViewById(R.id.btn_show);
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.popup, null);
        popupWindow =new PopupWindow(layout, LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT);
        Button btn_dismiss = (Button) layout.findViewById(R.id.btn_dismiss);
        btn_dismiss.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                openMenu();
            }
        });
        btn_show.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                openMenu();
            }
        });
    }

    public void btn_showOnClicked() {
        openMenu();
    }

    public void btn_dismissOnClicked() {
        openMenu();
    }

    public void openMenu() {
        if (!flag) {
            popupWindow.setAnimationStyle(R.style.PopupAnimation);
            popupWindow.showAtLocation(findViewById(R.id.btn_show), Gravity.NO_GRAVITY, 0, 0);
            popupWindow.setFocusable(true);
            popupWindow.update();
            flag =true;
        } else {
            popupWindow.dismiss();
            popupWindow.setFocusable(false);
            flag =false;
        }
    }
}