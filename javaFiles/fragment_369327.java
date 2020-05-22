listview=(ListView) findViewById(R.id.list_view);

        listViewArrayAdapter=new ListViewArrayAdapter(this,listviewArrayList);// set data for your arraylist (listviewArrayList) before using it here
        listview.setAdapter(listViewArrayAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putString("yourTextId",listviewArrayList.get(position).getYourText);
                bundle.putInt("dataImg", listviewArrayList.get(position).getImageId());


                Intent intent = new Intent(MainActivity.this, SeconActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });