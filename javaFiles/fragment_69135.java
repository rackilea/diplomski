String[] array={"stack","queue","arraylist"};
    ListView lst;
    //In onCreate function
    lst=(ListView)findViewById(R.id.lst_view);
     ArrayAdapter<String> adpt=new ArrayAdapter<String>(this,R.layout.what_ever_your_xml,array);
    lst.setAdapter(adpt);

  //function of listview 
  //arrayadapter is used for converting string type array into listview

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String s;

                    s=((TextView)view).getText().toString();
                    Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                }
            });