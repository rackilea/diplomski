public class InnerActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        TextView view = (TextView) findViewById(R.id.clickableButtonWithBorder);

        x xInstance = new x();
        xInstance.func();
        view.setText(String.valueOf(xInstance.getSS()));

    }

    private class x {
        int ss;

        public void func() {
            ss = 3;
        }

        public Integer getSS()
        {
            return ss;
        }
    }

}