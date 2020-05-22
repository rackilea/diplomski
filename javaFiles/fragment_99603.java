public class MainActivity extends AppCompatActivity {

int answer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

public static double main(String[]args){
    int x , y;
    x = 2;
    y = 3;
    this.answer = y + x;
    return 0;
}
public void buttonOnClick(View v){
    EditText txtoutput = (EditText) findViewById(R.id.editText);
    txtoutput.setText(String.valueOf(this.answer));


  }

}