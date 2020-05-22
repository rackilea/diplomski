ListView lv = (ListView) findViewById(R.id.list);
ArrayList<String> your_array_list = new ArrayList<String>();

 "loop here -> get each String and add it to list : ( your_array_list.add( fightCard ) ) "

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

     lv.setAdapter(arrayAdapter);