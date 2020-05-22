public class Individuals extends ListFragment {
private List<ParseObject> mOrganization = new ArrayList<ParseObject>();
SearchView sv;
IndividualsAdaptor adaptor;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.individuals, container, false);
}

@Override
public void onViewCreated(View view, Bundle b) {
    super.onViewCreated(view, b);
    sv = (SearchView) view.findViewById(R.id.searchView1);
    adaptor = new IndividualsAdaptor(getActivity(), mOrganization);
    setListAdapter(adaptor);
    ParseQuery.getQuery("_User").findInBackground(this);

    sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String text) {
            return false;
        }
        @Override
        public boolean onQueryTextChange(String text) {
            adaptor.getFilter().filter(text);
            return true;
        }
    });
}

@Override
public void done(List<ParseObject> scoreList, ParseException e) {
    if (e == null) {
        Log.d("score", "Retrieved " + scoreList.size() + " _User");
        mOrganization.clear();
        mOrganization.addAll(scoreList);
        ((IndividualsAdaptor) getListAdapter()).updateBackupList(mOrganization);
        ((IndividualsAdaptor) getListAdapter()).notifyDataSetChanged();
    } else {
        Log.d("score", "Error: " + e.getMessage());
    }
}
}