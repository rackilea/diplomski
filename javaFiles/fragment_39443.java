public class DemoActivity extends AppCompatActivity{


@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.demo_activity);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.demo_preferences, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch(item.getItemId()) {
        case R.id.menu_settings:
            Intent i = new Intent(DemoActivity.this , PrefDemoActivity.class);
            i.putExtra("Passed", "Test--##%%&&");
            startActivity(i);
            break;
        default:
            throw new RuntimeException("unknown menu selection");
    }

    return true;
}
}