@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.fragment_service, container, false);
    getActivity().setTitle(getString(R.string.title_services));

    String name = "Ivan";
    Double price = 25.0;
    String duration = "23:30";
    String description = "ahjdbsjdhask skdfksd";
    items = new ArrayList<>();

    for (int i = 0; i < 15; i++) {
        items.add(new Service(name, price, duration, description));
    }

    frameLayout = view.findViewById(R.id.layout_snack);
    recyclerView = view.findViewById(R.id.service_list);
    itemsAdapter = new ServiceAdapter(R.layout.service_item, items);
    fab = view.findViewById(R.id.fab_service);

    recyclerView.setLayoutManager(new 
    LinearLayoutManager(getActivity().getBaseContext()));
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    recyclerView.setAdapter(itemsAdapter);
    return view;
}