public class MyAndroidAppActivity extends Activity {

ImageButton imageButton;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    addListenerOnButton();

}

public void addListenerOnButton() {

    imageButton = (ImageButton) findViewById(R.id.imageButton1);

    imageButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

           Toast.makeText(MyAndroidAppActivity.this,
            "ImageButton is clicked!", Toast.LENGTH_SHORT).show();

        }

    });

}

    }