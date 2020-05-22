public class MainActivity extends Activity {

    ToggleButton togglebutton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout rootView = new LinearLayout(this);
        rootView.setOrientation(LinearLayout.HORIZONTAL);
        rootView.setWeightSum(100);

        LinearLayout.LayoutParams par = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,30);
        LinearLayout.LayoutParams part = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,70);

        togglebutton = new ToggleButton(this);
        button = new Button(this);
        button.setText("Click Me");
        button.setLayoutParams(par);
        button.setLayoutParams(part);

        rootView.addView(button);
        rootView.addView(togglebutton);

        setContentView(rootView);
    }

}