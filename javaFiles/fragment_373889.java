public class Main extends FragmentActivity {

  private ListView mListView; 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout_id);
    mListView = (ListView)findViewById(R.id.list);
 }

 private class fetchStudentInfo extends AsyncTask<String, Void, List<mStudentInfo>> {
        @Override
        protected List<mStudentInfo> doInBackground(String... urls) {
            …
        }

        public void onPostExecute(List<mStudentInfo> StudentInfoCollection) {
            mListView.setListAdapter(new StudentInfoAdapter((Activity) mainAppContext, StudentInfoCollection));
        }
    }

}