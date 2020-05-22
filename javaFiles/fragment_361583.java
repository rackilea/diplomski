import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class EventsActivity extends FragmentActivity implements ActionBar.TabListener {
    //needs R string
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_container);

        //Set up the action bar to show tabs
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Add a tab to the action bar
        //needs R.string values
        actionBar.addTab(actionBar.newTab().setText("Tab 1").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab 2").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab 3").setTabListener(this));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        //restores the previously serialised current tab position
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)){
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        //Serialise the current tab position
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.events, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        //Uses container view
         android.support.v4.app.Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition()+1);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.events_container, fragment).commit();

        //getSupportFragmentManager().beginTransaction()
        //.add(R.id.assessment_container, fragment).commit();

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction) {
        //Do nothing
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        //Do nothing
    }

    //dummy test
    public static class DummySectionFragment extends Fragment {
        public static final String ARG_SECTION_NUMBER = "placeholder_text";
        GridView gridView;
        static final String[] numbers1 = new String[] {

            "1", "2", "3", "4", "5"
        };
        static final String[] numbers2 = new String[] {

            "6", "7", "8", "9", "10"
        };
        static final String[] numbers3 = new String[] {

            "11", "12", "13", "14", "15"
        };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_events,
                    container, false);

            GridView gridview = (GridView)rootView.findViewById(R.id.gridview);

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, numbers1);
                    gridview.setAdapter(adapter1);
                    break;
                case 2:
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, numbers2);
                    gridview.setAdapter(adapter2);
                    break;
                case 3:
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, numbers3);
                    gridview.setAdapter(adapter3);
                    break;
                default:
                    //textView.setText("HELLO");
                    break;
            }
            return rootView;
        }
      }
}