lv = (ListView) findViewById(R.id.listView1);
    lv.setAdapter(new myProductAdapter(setupArrayProductList((ArrayList<myProduct>) ProductList), OrderFirstGridPage.this));
    lv.setSelector(R.drawable.selector_for_position_list);      

 lv.setOnItemClickListener(new OnItemClickListener() {

                                            @Override
                                            public void onItemClick(AdapterView<?> parent,
                                                    View view, int position, long id) {
                                                Log.d("My POSITION",""+position);

                                            }
                                        });