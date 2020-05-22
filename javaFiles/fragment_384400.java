@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_cities_list, container, false);

    // Set the adapter
    if (view instanceof RecyclerView) {
        Context context = view.getContext();

        //Get cities array from resource
        String[] cities = context.getResources().getStringArray(R.array.Cities);
        List<DummyItem> mValues = new ArrayList<>();
        for(int i = 0; i < cities.length; i++) {
            mValues.add(new DummyItem(String.valueOf(i + 1), cities[i], ""));
        }

        RecyclerView recyclerView = (RecyclerView) view;
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        //Pass the mValues to adapter
        recyclerView.setAdapter(new MycitiesRecyclerViewAdapter(mValues, mListener));
    }

    return view;
}