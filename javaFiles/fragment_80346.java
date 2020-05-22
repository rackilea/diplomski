public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ...

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        String itemName = item.getTitle().toString();
        if ("element".equals(itemName){
            //Do what you want...
        }
    }

    ...
}