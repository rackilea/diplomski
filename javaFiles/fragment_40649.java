public class ForecastFragment extends Fragment implements TaskCompleteListener {

    ArrayAdapter<String> mForecastAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //This is just a placeholder until we fetch the real data from web
        //String[] data = {"Fetching data from server"};

        new Comm(this).execute("params...");

        return rootView;
    }

    @override
    public void onTaskComplete(String dataArray){
        data = parseJson(dataArray);
        List<String> forecast = new ArrayList<String>(Arrays.asList(data));
        mForecastAdapter = new ArrayAdapter(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                data);

        ListView listView = (ListView) rootView.findViewById(R.id.listViewForecast);
        listView.setAdapter(mForecastAdapter);
    }
}