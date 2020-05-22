@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
     String item = arg0.getAdapter().getItem(arg1);
     if(item.equals("Advanced"){
       Intent intent = Intent(Homeactivity.this,SettingsActivity.class);
       startActivity(intent);                     
     }                                
 }