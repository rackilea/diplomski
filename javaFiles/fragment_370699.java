// show dialog
pDialog = new ProgressDialog(this);
pDialog.setMessage(getString(R.string.loading));
pDialog.show();

// fetch the data first 
SQLiteHandler db = new SQLiteHandler(this.getApplicationContext());
contactList = db.getMyContactDetails();    

// now the list has data so display it
listView = (ListView) findViewById(R.id.contacts_list);
adapter = new ContactsListAdapter(this, contactList);
listView.setAdapter(adapter);

// dismiss the dialog 
hidePDialog();