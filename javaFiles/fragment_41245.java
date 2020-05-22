public class ScreenPuzzle extends AppCompatActivity {

    private ListView list;
    private TextView textUnresolved;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_puzzle);

        list = (ListView) findViewById(R.id.list_puzzle);
        textUnresolved = (TextView) findViewById(R.id.text_unresolved);
        loading = (ProgressBar) findViewById(R.id.loading_rank);

        ParseQuery<ParseObject> query = new ParseQuery<>("Puzzle");
        query.whereEqualTo("puzzle", "somePuzzle");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) new BackgroundOperation(objects).execute();
                else e.printStackTrace();
            }
        });
    }

    private class BackgroundOperation extends AsyncTask<Void, Void, ArrayList<Puzzle>> {

        private List<ParseObject> objects;
        private ArrayList<Puzzle> listPuzzle;

        public BackgroundOperation(List<ParseObject> objects) { this.objects = objects; }

        @Override
        protected ArrayList<Puzzle> doInBackground(Void... voids) {
            listPuzzle = new ArrayList<>();
            for (ParseObject object : objects) listPuzzle.add(new Puzzle(object));

            return listPuzzle;
        }

        @Override
        protected void onPostExecute(ArrayList<Puzzle> listPuzzle) {
            if (list != null && listPuzzle.size() != 0) {
                final AdapterPuzzle adapterPuzzle = new AdapterPuzzle(listPuzzle, ScreenPuzzle.this);
                list.setAdapter(adapterPuzzle);
            } else textUnresolved.setVisibility(View.VISIBLE);

            loading.setVisibility(View.GONE);
        }
    }
}