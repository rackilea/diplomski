@Override
public Fragment getItem(int position) {
      return MyFragment.newInstance(position);
}

    public class Frag_UserItems extends Fragment {
...
       public static MyFragment newInstance (int position){ 
             // assuming category is an enum
             Bundle bundle = new Bundle();
             MyFragment fragment = new MyFragment();
             bundle.setInt("num", position);
             fragment.setArguments(args);
             return fragment;
            }
...
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_user_items, container, false);

    //fetch the arguments and get the data from the reposotry
   // and filter them how you want
     Bundle args = getArguments();
     int num = args.getInt("num");
     List<MyItem> items = ...
     // bind view..
      initview(rootView, items);
      return rootView;
    }
}