public class BasicActivity extends FragmentActivity {   

    protected void onTabChanged(){ }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
          case R.id.stad:
            TabHost tabHost = (TabHost) getParent().findViewById(android.R.id.tabhost);
            tabHost.setCurrentTab(4); //here is me Sub.class
            onTabChanged();
      break;
      default:
         return false;      
    }
    return true;
}

public class Sub extends BasicActivity {

    protected void onTabChanged() { stackAFragment(); }

   ....
}