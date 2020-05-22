@Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        TextView text = (TextView) arg1;
        if(text.getText().toString().equals("Advanced"){
           Intent intent = Intent(Homeactivity.this,SettingsActivity.class);
           startActivity(intent);             
         }                                
     }