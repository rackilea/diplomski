@Override
protected void onRestoreInstanceState(Bundle savedInstanceState){

    super.onRestoreInstanceState(savedInstanceState);

    counter = savedInstanceState.getInt(counter_value);
    toDoList = savedInstanceState.getStringArrayList("key");

    // Add this for-loop to restoring your list
    for(String str : toDoList){
        ListItems.addView(createNewTextView(str));
    }
}