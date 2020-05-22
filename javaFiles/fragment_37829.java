public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

      final TextView tv = (TextView) findViewById(R.id.winnerTextView);
    }

    public void getWinner() {
        tv.setText("does not work");
    }
}