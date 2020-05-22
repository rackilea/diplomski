public class ReallyEmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_really_empty);

        SharedPreferences preferences = this.getSharedPreferences("UNIV", MODE_PRIVATE);

        String uni = preferences.getString("UNIV", "0");
        Log.d("LOAD", uni);

        if (uni.equals("0")) {
            startActivity(new Intent(ReallyEmptyActivity.this, MainActivity.class));
        } else if (uni.equals("uni1")) {
            startActivity(new Intent(ReallyEmptyActivity.this, Uni1.class));
        } else {
            startActivity(new Intent(ReallyEmptyActivity.this, Uni2.class));
        }

        finish();

    }
}