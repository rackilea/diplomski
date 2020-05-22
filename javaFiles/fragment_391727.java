protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
        case ReqCode:
            if (resultCode == RESULT_OK) {
                ArraySubs(data);
                break;
            }
    }
}

public void ArraySubs(Intent data) {
    try{
        Bundle b = data.getExtras();
        String[] subChoices = b.getStringArray("selectedItems");
        ListView lv = (ListView) findViewById(R.id.lv_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, subChoices);
        lv.setAdapter(adapter);
    }
    catch(Exception e){
        Log.e("MainActivity", e.getMessage());
    }
}