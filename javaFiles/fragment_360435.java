public class MainActivity extends Activity {

    long a =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1 = (EditText) findViewById (R.id.editText1);
        final EditText et2 = (EditText) findViewById (R.id.editText2);
        final EditText et3 = (EditText) findViewById (R.id.editText3);
        Button btn1  = (Button)   findViewById (R.id.button1)  ;
        final TextView tv1 = (TextView) findViewById (R.id.textView1);

        btn1.setOnClickListener(new OnClickListener{
            @Override
            public void onClick (View v){
                int day = Integer.parseInt(et1.getText().toString());
                int month = Integer.parseInt(et2.getText().toString());
                int year = Integer.parseInt(et3.getText().toString());

                tv1.setText(String.valueOf(MainActivity.this.getAge(year, month, day)));
            }
        });
    }


    public int getAge (int _year, int _month, int _day) {

        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a;         

        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(_year, _month, _day);
        a = y - cal.get(Calendar.YEAR);
        if ((m < cal.get(Calendar.MONTH))
                        || ((m == cal.get(Calendar.MONTH)) && (d < cal
                                        .get(Calendar.DAY_OF_MONTH)))) {
                --a;
        }
        if(a < 0)
                throw new IllegalArgumentException("Age < 0");
        return a;
    }

}