public class CustomizedListView extends Activity {

    private Button btnLoadMore;

    public void onCreate(){
        btnLoadMore = new Button(this);
        <do stuff>
        btnLoadMore.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View arg0) {
               // Starting a new async task
               new LoadMoreListView().execute();
           }
        });

        new LoadMoreListView().execute();// execute the AsyncTask once in the onCreate, so you don't have to duplicate the code here to load the listview.

    }

    private class LoadMoreListView extends AsyncTask<Void, Void, Boolean> {

        @Override 
        protected void onPreExecute() {
            < Show dialog>;
        }

        @Override
        protected Void doInBackground(Void... unused) {
           Boolean listIsEmpty;

           < Page request>;
           < Retrieve element list>;
           < If element list size == 0, listIsEmpty = true; return listIsEmpty>;

           < Process elements, fill list etc.>;
           < End of doInBackground, listIsEmpty = false; return listIsEmpty>;

        }

        @Override
        protected void onPostExecute(Boolean listIsEmpty) {
            < If listIsEmpty == true -> btnLoadMore.setVisibility(View.GONE);>
            < Close dialog>
        }
    }
}
}