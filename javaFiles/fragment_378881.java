public class Frag_UserItems extends Fragment {
...
       public static MyFragment newInstance (int itemsNumber, Category category){ 
             // assuming category is an enum
             Bundle bundle = new Bundle();
             MyFragment fragment = new MyFragment();
             bundle.setInt("num", itemsNumber);
             bundle.setString("category", category.toString());
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
     String num = args.getString("category");
     List<MyItem> items = ...
     // bind view..
      initview(rootView, items);
      return rootView;
    }
}