public class MainActivity extends AppCompatActivity {


    // ToolBar
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ...........
        .....................

        // ToolBar
        mToolBar = (Toolbar) findViewById(R.id.toolbar);

        // Required to use Toolbar as ActionBar
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("StackOverflow");

        // Dismiss Action
        mToolBar.setNavigationIcon(R.drawable.close);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Do something
                Toast.makeText(getApplicationContext(), "Dismiss", Toast.LENGTH_SHORT).show();
            }
        });

        // SaveNote Action
        mToolBar.inflateMenu(R.menu.menu_main);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.saveNote)
                {
                    // Do something
                    Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


        .............
        ....................... 
    }
}