//declare your arraylist here
protected void onCreate(Bundle savedInstanceState){...}

@Override
public Loader<List<News>> onCreateLoader(int id, Bundle args) {...}

@Override
onLoadFinished(Loader<List<News>> loader, List<News> data){
//assign data to your arraylist
}