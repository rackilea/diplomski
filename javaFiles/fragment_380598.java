public class MainActivity extends Activity 
   {

    SharedPreferences sp;
    int val=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=this.getSharedPreferences("service_validation", MODE_WORLD_READABLE);
        val=sp.getInt("VALIDATION", val);
                .
                .// you can put here anything code
                .
        }
.
.// you can put here anything method
.
.
}