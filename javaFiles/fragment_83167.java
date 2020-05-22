protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_parcelable_text);

    dataTableScrollView = (RelativeLayout) findViewById(R.id.scrollView1);

   //Get values for intent when activity started for firsttime
   Bundle extras = getIntent().getExtras(); 
   if (extras != null) 
    {
        //Get dataListView as String 
    dataListView    = extras.getString("dataListView");
    }

   //Get values on orientation 
   if( savedInstanceState != null )
    { 
       dataListView = savedInstanceState.getString("dataListView");
    }


   //Add extra String PARCELABLE_STRING
   dataListView += savedInstanceState.get(PARCELABLE_STRING)+"\n";


    setAllDataToListView();
}

//save info when screen orientation 
@Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

  outState.putString("dataListView",dataListView);
}   


private void setAllDataToListView(){
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.
            LAYOUT_INFLATER_SERVICE);

    View newListViewElement = inflater.inflate(R.layout.activity_parcelable_text, null);

    TextView newDataTextView = (TextView) newListViewElement.findViewById(R.id.scrollViewTextView);

    newDataTextView.setText(dataListView);

    dataTableScrollView.addView(newListViewElement, 0);
}