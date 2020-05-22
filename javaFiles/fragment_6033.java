public class MainActivity extends AppCompatActivity implements View.OnClickListener{
RecyclerView recyclerView;
SimpleRecyclerAdapter simpleRecyclerAdapter;
LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
new GetData().execute();



}


public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.VersionViewHolder> {

 //from this I would like to execute getData class

}

public class GetData extends AsyncTask<>{
   @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
         recyclerView.setAdapter(new SimpleRecyclerAdapter());
    }
}