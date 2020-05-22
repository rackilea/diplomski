public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] myArray =
                new String[] {
                        "Tomato", "Potato", "Carrot", "Mushroom", "Beef", "Cheese", "Lettuce",
                        "Bread", "Milk", "Spinach", "Chicken", "Rice"
                };

        ListView myList = (ListView) rootView.findViewById(R.id.list_main);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                                         myArray);

        myList.setAdapter(adapter);

        return rootView;
    }
}