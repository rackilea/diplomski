Type listType = new TypeToken<ArrayList<StaffArray>>(){}.getType();
Array = new ArrayList<>();
Array = new Gson.fromJson(getIntent().getString("Array", listType));

final ArrayAdapter arrayAdapter =new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, Array);
    if (Array == null)
    {
        Toasty.info(createProject.this,"Select a Staff Memebr",Toasty.LENGTH_LONG).show();
    }
    else
    {
        StaffListView.setAdapter(arrayAdapter);
    }