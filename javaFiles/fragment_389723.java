List<String> lst = dh.selectAll();
lv = (ListView)findViewById(R.id.listView1);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                         android.R.layout.simple_list_item_multiple_choice, lst);

lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
lv.setListAdapter(adapter);