public class FirstActivity extends Fragment implements OnClickListener {

int counter;
View v ;

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

            v = inflater.inflate(R.layout.lin, container, false);

    TextView temp = (TextView) v.findViewById(R.id.textView2);

    //Set the buttons
    Button button2 = (Button) v.findViewById(R.id.button2);


    //+++ BUTTON
    button2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub//Get content of TextView
            TextView temp = (TextView) this.v.findViewById(R.id.textView2);
            //Convert the string to an integer
            counter = Integer.parseInt(temp.getText().toString());
            counter++;
            temp.setText("" + counter);
            String stringData = temp.getText().toString();
            SharedPreferences.Editor editor = someData.edit();
            editor.putString("sharedString", stringData);
            editor.commit();
        }

    });
    //END OF +++ BUTTON

    return v;
  }
}