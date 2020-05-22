@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(
            R.layout.fragment_products_list, container, false);


    //Product filters
     RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerview);
    expandFiltersButton = (ImageButton) view.findViewById(R.id.expand_filters);
    expandableZone = (LinearLayout) view.findViewById(R.id.expandable_zone);

    expandFiltersButton.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {

            if(expandableZone.isShown()){
                expandableZone.setVisibility(View.GONE);
                expandFiltersButton.setImageResource(R.drawable.ic_more_24dp);
            }else{
                expandableZone.setVisibility(View.VISIBLE);
                expandFiltersButton.setImageResource(R.drawable.ic_less_24dp);
            }
        }
    });

    setupRecyclerView(rv);

    mRecyclerView = rv;
    loadUpdates();
    return view;
}