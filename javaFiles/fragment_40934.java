@Override
public void onItemSelected(AdapterView<?> arg0, View v, int position, long arg3) {
    Log.v("Value", "Language Value: " + position);
    if(position == 0){
         setLocale("en");
    }
    else{
         setLocale("fr");
    }
}