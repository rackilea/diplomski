public class MainActivity extends Activity {
        EditText edt;
        EditText edt2;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
     edt=(EditText)findViewById(R.id.editText1);
     edt2=(EditText)findViewById(R.id.editText2);   
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     Calendar c = Calendar.getInstance();
     Calendar c1=Calendar.getInstance();
     c1.setTime(new Date());
     c.setTime(new Date()); // Now use today date.
     c.add(Calendar.DATE, 7); // Adding 7 days
     String ToDate = sdf.format(c.getTime());
     String FromDate = sdf.format(c1.getTime());
     edt2.setText(FromDate);
     edt.setText(ToDate);

        }