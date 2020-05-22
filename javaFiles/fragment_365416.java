public class SearchActivity extends AppCompatActivity {

RecyclerView rv;
SearchView sv;
ArrayList<Accordo> chords = null;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_search);

    chords = (ArrayList<Accordo>) getIntent().getSerializableExtra("chords");

    sv = (SearchView) findViewById(R.id.testo_ricerca);
    rv = (RecyclerView) findViewById(R.id.lista_ricerca);
    rv.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));
    rv.setHasFixedSize(true);

    final SearchAdapter adapter = new SearchAdapter(this, chords);
    rv.setAdapter(adapter);

    //SEARCH
    sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            //FILTER AS YOU TYPE
            final List<Accordo> filteredModelList = filter(chords, newText);
            adapter.setFilter(filteredModelList);
            return true;
        }
    });

}

private List<Accordo> filter(List<Accordo> models, String query) {
    query = query.toLowerCase();

    final List<Accordo> filteredModelList = new ArrayList<>();
    for (Accordo model : models) {
        final String text = model.getName().toLowerCase();
        if (text.contains(query)) {
            filteredModelList.add(model);
        }
    }
    return filteredModelList;
}
}