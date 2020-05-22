1  lv.setOnItemClickListener(new OnItemClickListener() {
 2      public void onItemClick(AdapterView<?> parent, View view, 
                                int position, long id) {
 3
 4      public void onListItemClick(ListView, parent, View v,
                                    int position, long id);
 5      }
 6
 7      if (position == "Braford City") {
 8          Intent intent = new Intent(this, Bradford.class);
 9          startActivity(intent);
10      }
11
12