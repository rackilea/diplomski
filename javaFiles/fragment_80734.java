public class HomeFragment extends Fragment {
private TextView textView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle=getArguments();
      View rootView=inflater.inflate(R.layout.fragment_home,container,false);

        // ####### ALWAYS initialise your view components like below ##
        TextView welcomeMessage = (TextView) findViewById(R.id.PUT_TEXTVIEW_ID_HERE);

        // ###### The section below fetches the 'name' value from the first activity ###
        SharedPreferences preferences = 
     PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String username = preferences.getString("Name", "DEFAULT_STRING");
         /*You can change DEFAULT_STRING to be any string you want. If there 
         isn't any data to pull from SharedPrefs, it will show this string instead!*/
        // ###################


        textView.welcomeMessage("Welcome to FoodCourt " + username);
      return rootView;
    }

}