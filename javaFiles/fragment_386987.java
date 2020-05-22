public class ShoppingActivity extends Activity {

    CheckBox checkBox1, checkBox2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        // The checkbox for Hamburger
        checkBox1 = findViewById(R.id.checkBox1); 
        // The checkbox for Cheese Burger
        checkBox2 = findViewById(R.id.checkBox2); 

        // The textView where you display the selected things
        textView = findViewById(R.id.textView);

        // Add listeners to your checkboxes to tell them to update the text view when they are clicked
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextView();
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextView();
            }
        });
    }


    // This updates the TextView depending on what is checked   
    private void updateTextView() {
        String text = "";
        if(checkBox1.isChecked()) {
            text += "Hamburger\n";
        }
        if(checkBox2.isChecked()) {
            text += "Cheese Burger\n";
        }
        textView.setText(text);
    }

}