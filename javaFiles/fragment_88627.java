public class YourActivity extends AppCompatActivity implements View.OnClickListener {

    public static FirebaseDatabase mFirebaseDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        final EditText edittext = (EditText) findViewById(R.id.edittext);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edittext.getText().toString().length() > 0) {
                    mFirebaseDatabase.getReference("myref").push().setValue(edittext.getText().toString());
                }
            }
        });
    }
}