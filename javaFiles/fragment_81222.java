public class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {

    FragmentActivity activity;        

    public NavigationListener(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // ...

        if(fragmentTransaction){
            activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

            // ...
        }
    }
}