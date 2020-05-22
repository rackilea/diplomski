public class MainActivity extends AppCompatActivity {

    // make it class scope.
    private TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
      ...

      TextView tv = (TextView) findViewById(R.id.winnerTextView);

      ...
    }

    public void getWinner() {
        tv.setText("does not work");
    }
}