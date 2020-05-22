@Override
public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.activity_choose_contacts_action, menu);

    if (adapter.getSelectedItemCount() == 0) {
        menu.findItem(R.id.add).setVisible(false);
    } else {
        menu.findItem(R.id.add).setVisible(true);
    }

    if (getSupportActionBar() != null) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    return true;
}
.....
// Checking previously selected contacts
        if (selectedContacts != null) {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {

                List<Integer> selectedIndexes = new ArrayList<>();

                // Finding indexes of selected contact ids
                for (int i = 0; i < contactList.size(); i++) {
                    if (selectedContacts.contains(contactList.get(i).getUserId())) {
                        selectedIndexes.add(i);
                    }
                }

                // Triggering click on each selected item
                for (int j = 0; j < selectedIndexes.size(); j++) {
                    recyclerView.getChildAt(selectedIndexes.get(j)).performClick();
                }
                invalidateOptionsMenu();
            }, 500);
......
 @Override
        public void onClick(View view, int position) {
            // invalidateOptionsMenu(); (resetting onCreateOptionsMenu) executed with 600 millis delay, otherwise it will happen before the 500 millis
            // delay when checking previously selected contacts
            new Handler(Looper.getMainLooper()).postDelayed(() -> invalidateOptionsMenu(), 600);
        }