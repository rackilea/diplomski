public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        ....

        // Changing image in NavigationDrawer

        // First Item
        MenuItem item1 = navigationView.getMenu().getItem(0);
        ImageView img = ((ImageView) item1.getActionView().findViewById(R.id.navImage));
    }
}