textView.setText( firstHouer + " : " + firstdMinute + " - " + seccoundHouer + " : " + seccoundMinute );
addArray.add(firstHouer + " : " + firstdMinute + " - " + seccoundHouer + " : " + seccoundMinute);
addArray.notifyDataSetChanged();
//^^^^^^^^^^^^^^^^^^^
// once adapter is linked and later data source is modified , notify it
// only then adapter go though the data source 
//and update the listView/RecyclerView accordingly