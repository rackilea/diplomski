public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button menu_button = (Button) findViewById(R.id.menu_button);
        TestMenu myMenu = new TestMenu(this, menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMenu.show();
            }
        });
    }
}