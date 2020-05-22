Activity Main code,

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loadData();
}

private void loadData() {

    getSupportFragmentManager().beginTransaction()
            .replace(R.id.frame_layout,new ListViewFragment())
            .commit();

}
}