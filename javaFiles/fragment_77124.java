public class TestActivity extends Activity 
{
  private GetTask getTask;
  public ListView fList;

  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    getTask = new GetTask(); 
    getTask.execute();
    fList = (ListView) findViewById(R.id.lstview);
  }

  public class GetTask extends AsyncTask<Void, Void, List> 
  {
    @Override
    protected List doInBackground(Void... params) {
      return load();
    }      

    @Override
    protected void onPostExecute(List result) {
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, headlines);

      fList.setAdapter(adapter);
    }
  }

  private List load() { 
    // get your data from http
    // add to your list, probably you can use model.
    List headlines;
    headlines.add(data);

    return headlines;
  }


}