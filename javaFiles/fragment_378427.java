StartSearch.myList22.clear();
 StartSearch.myList22.addall(NewList);
 arrayAdapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            StartSearch.myList22 ); 
lv.setAdapter(arrayAdapter);