@Override
public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
    inflater.inflate(R.menu.activity_recent_destinations, menu);
    MenuItem item = menu.findItem(R.id.menu_action_item_clear);
    View actionView = item.getActionView();
    // Set the listener on the root view or any children if necessary
    actionView.setOnClickListener(...);
}