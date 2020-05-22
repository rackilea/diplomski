public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setupPopup();

}

private void setupPopup() {

    ImageView btn = findViewById(R.id.btnShowDialog);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager manager = getSupportFragmentManager();
            PopupFragment dialog = new PopupFragment();
            dialog.show(manager, "MessageDialog");
        }
    });

}

}