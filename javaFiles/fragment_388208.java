public class MainScreen extends ExpandableListActivity 
implements    OnChildClickListener { 
    ArrayList<String> mData = new ArrayList<String>(); 
    ListView mListView; ArrayAdapter<String> mAdapter;
    ArrayList<String> ArrayOfBeerNames; 
    ArrayList<Beer> ArrayOfBeers; 
    ExpandableListView expandbleList;
    Document doc;
  @Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.taplist);
    expandbleLis = getExpandableListView();    

    expandbleLis.setDividerHeight(2);
    expandbleLis.setGroupIndicator(null);
    expandbleLis.setClickable(true);


    ArrayOfBeerNames = new ArrayList<String>();

    ArrayOfBeers = new ArrayList<Beer>();

    new progression().execute();
}


public class progression extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog = new ProgressDialog(
                MainScreen.this);

        @Override
        protected void onPreExecute() {
            this.dialog.setCancelable(true);
            this.dialog
                    .setMessage("Fetching the up-to-date list..., Please Wait.......");
            this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            this.dialog.setProgress(0);
            this.dialog.setMax(1000);
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                /*
                 * This is run on a background thread, so we can sleep here or
                 * do whatever we want without blocking UI thread. A more
                 * advanced use would download chunks of fixed size and call
                 * publishProgress();
                 */


   String URL = "http://www.dogfish.com/restaurant/menus/brews-whats-on-tap.htm";
    try {
        doc = Jsoup.connect(URL)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
                .get();



    } catch (Exception ex) {
        ex.printStackTrace();
        //mData.clear();
        //mData.add("Exception: " + ex.toString());
    }


            } catch (Exception e) {
                //Log.e("tag", e.getMessage());
                /*
                 * The task failed
                 */

            }

            /*
             * The task succeeded
             */
            return null;
        }

        protected void onProgressUpdate(Void... params) {
            super.onProgressUpdate(params);

        }

        @Override
        protected void onPostExecute(final Void unused) {
            super.onPostExecute(unused);


            Elements updates = doc.select("p:matches(.+?)+p");            
        for(Element update: updates) {

            String TheUpdateTextWeGot = update.text();

            if((TheUpdateTextWeGot.contains("updated")))
            {
                String updatedate = "Current as of " + TheUpdateTextWeGot.substring(9, 20) + ".";       
            TextView tv = (TextView)findViewById(R.id.tv);
            tv.setText(updatedate);
            }
        }

        if(mData.size() == 0) {
            mData.add("Empty result");
        }

            if (this.dialog.isShowing()) {

                this.dialog.dismiss();

            }
            /*
             * Update here your view objects with content from download. It is
             * save to dismiss dialogs, update views, etc., since we are working
             * on UI thread.
             */

        }
    }