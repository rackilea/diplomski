boolean[] mItemState;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.majorslist);
    ListView mylist = (ListView) findViewById(R.id.majorslist);
    final String[] list={"Aerospace Engineering","Agricultural Engineering",
            "Biomedical Engineering","Chemical Engineering","Civil Engineering",
            "Computer Engineering","Electrical Engineering","Engineering Physics", 
            "Environmental Engineering","Industrial Engineering",
            "Materials Engineering","Mechanical Engineering"};
    mItemState = new boolean[list.length]
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListOfMajors.this,android.R.layout.simple_list_item_multiple_choice,list);
    mylist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toggle the state
            mItemState[position] = !mItemState[position];
            if (mItemState[position])
                Log.d("onItemClick","Major " + list[position] + " has been selected");
            else
                Log.d("onItemClick","Major " + list[position] + " has been deselected");
        }
    });

    mylist.setAdapter(adapter); 
}