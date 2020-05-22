public class Sweet extends ListFragment {
    String[] players = {"sweet A", "sweet B", "sweet C"};
    int[] images = {R.drawable.veg, R.drawable.veg2, R.drawable.veg};
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < players.length; i++) {
            map = new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        String[] from = {"Player", "Image"};
        int[] to = {R.id.nameTxt, R.id.imageView1};
        adapter = new SimpleAdapter(getActivity(), data, R.layout.sweet, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                selectItem(pos);
            }
        });
    }

    private void selectItem(int pos) {
        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (pos) {
            case 0:
                newFragment = new SweetA();
                transaction.addToBackStack(null);
                transaction.hide(this);
                transaction.add(R.id.containerID, newFragment);
                transaction.commit();
                break;

        }
    }

    @Override
    public String toString() {
        return "Home";
    }
}