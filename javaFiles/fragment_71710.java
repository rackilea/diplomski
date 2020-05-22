public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uni1onclick(View view) {
        SharedPreferences preferences = this.getSharedPreferences("UNIV",MODE_PRIVATE);
        SharedPreferences.Editor  editor = preferences.edit();

        editor.putString("UNIV","uni1");
        editor.commit();
        startActivity(new Intent(MainActivity.this,Uni1.class));
    }

    public void uni2onclick(View view) {

        SharedPreferences preferences = this.getSharedPreferences("UNIV",MODE_PRIVATE);
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putString("UNIV","uni2");
        editor.commit();

        startActivity(new Intent(MainActivity.this,Uni1.class));
    }
}