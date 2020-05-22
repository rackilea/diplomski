ListView listView = (ListView) findViewById(R.id.list);
ArrayList<String> arrayList = new ArrayList<>();//create a list to store the Strings
for(int count=0; count <= cc.size(); count++){
    nameeng =  cc.get(count).getNameEn();
    arrayList.add(nameeng);//add data to list
}
ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);// create adapter using the list before
listView.setAdapter(adapter);//set the adapter to the listView to show data