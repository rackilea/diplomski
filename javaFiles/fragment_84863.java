@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
inflater.inflate(R.menu.edit_work, menu);
//You should create new menu for Edit_work fragment with both home and pen icons
super.onCreateOptionsMenu(menu, inflater);
}  
@Override public boolean onOptionsItemSelected(MenuItem item) {
}