public abstract class NavigationMenu extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_bar);

        Button loginButton = (Button) findViewById(R.id.navbtnHome);
        loginButton.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View view) 
            {
                Toast.makeText(getApplicationContext(), "Cameron, Im here", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(NavigationMenu.this, Login.class);
                startActivity(i);
            }
        });

        LinearLayout container = (LinearLayout)findViewById(R.id.container);
        container.addView(createView());
    }

    protected abstract View createView();
}