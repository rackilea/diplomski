public void saveData(Context context, int data){
    SharedPreferences sharedPref = getDefaultSharedPreferences(context);
    SharedPreferences.Editor spEditor = sharedPref.edit();
    spEditor.putInt("DATA", data);
    spEditor.commit();
}