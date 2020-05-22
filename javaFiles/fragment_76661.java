import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    final Fragment mapsFragment = new MapsFragment();
    final Fragment statsFragment = new StatsFragment();
    final Fragment newsFragment = new NewsFragment();
    final Fragment moreFragment = new MoreFragment();
    final FragmentManager fm = getSupportFragmentManager();

    Fragment firstFragment;
    private int tabId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        loadData();
        setOnCreateFragment(navigation,tabId);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            tabId = item.getItemId();
            switch (tabId) {
                case R.id.navigation_map:
                    fm.beginTransaction().hide(firstFragment).show(mapsFragment).commit();
                    firstFragment = mapsFragment;
                    break;
                case R.id.navigation_stats:
                    fm.beginTransaction().hide(firstFragment).show(statsFragment).commit();
                    firstFragment = statsFragment;
                    break;
                case R.id.navigation_news:
                    fm.beginTransaction().hide(firstFragment).show(newsFragment).commit();
                    firstFragment = newsFragment;
                    break;
                case R.id.navigation_more:
                    fm.beginTransaction().hide(firstFragment).show(moreFragment).commit();
                    firstFragment = moreFragment;
                    break;
            }
            return true;
        }
    };

    private void setOnCreateFragment(BottomNavigationView navigation, int tabId){

        fm.beginTransaction().add(R.id.container, moreFragment, "4").hide(moreFragment).commit();
        fm.beginTransaction().add(R.id.container, newsFragment, "3").hide(newsFragment).commit();
        fm.beginTransaction().add(R.id.container, statsFragment, "2").hide(statsFragment).commit();
        fm.beginTransaction().add(R.id.container, mapsFragment, "1").hide(mapsFragment).commit();

        if(tabId != -1){
            switch (tabId){
                case R.id.navigation_map:
                    fm.beginTransaction().show(mapsFragment).commit();
                    firstFragment = mapsFragment;
                    break;
                case R.id.navigation_stats:
                    fm.beginTransaction().show(statsFragment).commit();
                    firstFragment = statsFragment;
                    break;
                case R.id.navigation_news:
                    fm.beginTransaction().show(newsFragment).commit();
                    firstFragment = newsFragment;
                    break;
                case R.id.navigation_more:
                    fm.beginTransaction().show(moreFragment).commit();
                    firstFragment = moreFragment;
                    break;
            }
            navigation.setSelectedItemId(tabId);
        } else  {
            fm.beginTransaction().show(mapsFragment).commit();
            firstFragment = mapsFragment;
        }

    }

    @SuppressLint("ApplySharedPref")
    private void saveData(){
        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("tabId", tabId).commit();
    }

    private void loadData(){
        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        tabId = preferences.getInt("tabId",-1);
        //tag   = preferences.getString("tag",null);
    }

    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        fm.beginTransaction().hide(firstFragment).commitAllowingStateLoss();
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}