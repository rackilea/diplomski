listview = (ListView) findViewById(R.id.listView);
        name = getIntent().getExtras().getString("Name"); // receive name from Information
        weather = getIntent().getExtras().getString("Weather"); //receive weather
        date = getIntent().getExtras().getString("date2"); //receive date
        status = getIntent().getExtras().getString("Status"); // receive status
        objMyCustomBaseAdapter=new MyCustomBaseAdapter(getApplicationContext(),results);
listview.setAdapter(objMyCustomBaseAdapter);