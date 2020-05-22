// create this method to update the options (re-populate the ArrayAdapter)
// of course ArrayAdapter and randOptions should be GLOBAL
public void updateOptions() {
    adapter.clear(); 
    if (randOptions != null){
       for (String option : randOptions) {
           adapter.insert(option,adapter.getCount());
        }
    }     
    adapter.notifyDataSetChanged();
}