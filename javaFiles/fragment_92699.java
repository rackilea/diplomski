public class RecentsCardFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
   ListView  recentsList;

    private SwipeRefreshLayout refreshBooks;

     ArrayList<HashMap<String,String>> items = new ArrayList<>();

    //private  ProgressDialog progress;

    public static RecentsCardFragment newInstance() {
        RecentsCardFragment f = new RecentsCardFragment();
            return f;
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recents_card,container,false);
        recentsList = (ListView)rootView.findViewById(R.id.recents_list);
        ViewCompat.setElevation(rootView,50);
        refreshBooks = (SwipeRefreshLayout) rootView.findViewById(R.id.container);
        refreshBooks.setOnRefreshListener(this);


        getBooks();


        RecentsAdapter  adapter = new RecentsAdapter(getActivity().getApplicationContext(), items);

        recentsList.setAdapter(adapter);


        return rootView;
    }