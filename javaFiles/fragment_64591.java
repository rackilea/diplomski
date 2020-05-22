public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
        String key) {

    //Make sure the item changed was the list_preference 
    if(key.equals("list_preference")) {
        String value = sharedPreferences.getString(key, "Nothing");

        if(value.equals("Send_sms")) {
            //launch AlertDialog with list or launch new preference 
        }       
    }
}