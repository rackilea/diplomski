@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.

    MenuInflater inflater = getMenuInflater();
   inflater.inflate(R.menu.main, menu);

    View textEntryView = menu.findItem(R.id.menu_switch_toolbar).getActionView();

    toolbarSwitch = (Switch) textEntryView.findViewById(R.id.switch_toolbar);
    toolbarSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Log.d("SMSAT", "Test");
        }
    });

    return super.onCreateOptionsMenu(menu);

}