public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final StringBuffer stringBuffer = new StringBuffer();
        Button updateButton = (Button) findViewById(R.id.update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringBuffer
                        .delete(0, stringBuffer.length())
                        .append(System.currentTimeMillis());
            }
        });
    }
}