public class ListFragment extends Fragment{
    ListView listView;
    ArrayAdapter<stops> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<stops> mystops = new ArrayList<>();
        mystops.add(new stops("Corum", "Odysseum", "5min", R.drawable.green_tram));
        mystops.add(new stops("Corum", "Mosson", "2min", R.drawable.orange_tram));
        mystops.add(new stops("Corum", "Saint-Jean de Vedas", "1min", R.drawable.red_tram));

        adapter = new myListAdapter(getActivity(), mystops);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listView = (ListView) view.findViewById(R.id.stopsList);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setAdapter(adapter);
    }

    private static class myListAdapter extends ArrayAdapter<stops> {
        public myListAdapter(Context context, ArrayList<stops> stopList) {
            super(context, R.layout.item_view, stopList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null)
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_view, parent, false);

            stops currentStop = getItem(position);

            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentStop.getIconID());
            TextView nameText = (TextView)itemView.findViewById(R.id.item_nameTextView);
            nameText.setText(currentStop.getName());
            TextView destinationText = (TextView) itemView.findViewById(R.id.item_destinationTextView);
            destinationText.setText(currentStop.getDestination());
            TextView timeText = (TextView) itemView.findViewById(R.id.item_timeTextView);
            timeText.setText(currentStop.getSchedule());

            return itemView;
        }
    }