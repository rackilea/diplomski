private void setToolbar() {
    toolbarTop = (Toolbar) findViewById(R.id.toolbarAdjustScan);
    setSupportActionBar(toolbarTop);
    TextView search = (TextView)toolbarTop.findViewById(R.id.searchAdjustBtn);
    TextView titleToolbar = (TextView)toolbarTop.findViewById(R.id.titleToolbar);
    titleToolbar.setText("TakeInventory");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    getSupportActionBar().setElevation(0);

    search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), TakeInventoryResult.class);
           // Bundle args = new Bundle();
           //  args.putSerializable("ARRAYLIST",(Serializable)inList);
           // intent.putExtra("BUNDLE",args);
            startActivity(intent);
            finish();
        }
    });

}