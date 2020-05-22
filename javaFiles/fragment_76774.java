@Override
public void onCreate(Bundle icicle){
    super.onCreate(icicle);
    setContentView(R.layout.your_layout);

    getListView().setOnItemClickListener(this);
}

@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    // your stuff here
}
}