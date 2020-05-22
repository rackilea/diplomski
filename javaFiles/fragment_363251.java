public class MyActivity extends Activity {
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.myLayout);
        textView = (TextView)findViewById(R.id.myTextView);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
        int pos, long id) {

        switch(pos){
          case 0:
            String hours = "Office Hours:\n\tSummer: 9:00am - 10:00pm\n\tFall: 10:00am - 7:00pm";
            textView.setText(hours);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 35);

            break;
          case 1:
            String products = "Wood - $8/bag (kindling and fuel wood available)\n" +
                    "Ice - $2.75/bag (crushed and on occasion blocks)";
            textView.setText(products);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);

            break;
        }
}