public class MainHandlerFragment extends Fragment {

    //added this line
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MyTask().execute("xyzname");
    }   

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //updated this line
        view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    public class MyTask extends AsyncTask<String, Void, Organization> {
        @Override
        protected String doInBackground(String... urls) {
            // getting api calls
        }
        @Override
        protected void onPostExecute(String str) {
            loadData(str);
        }
    }
    public void loadData(String str){
        getSupportFragmentManager().beginTransaction()
        //updated this line
        ((TextView) view.findViewById(R.id.text_frag)).setText("name");
    }
}