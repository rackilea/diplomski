// Create the adapter to convert the array to views
UsersAdapter adapter = new ObjectParcelableAdapter(this, listofobjects);

// Attach the adapter to a ListView
ListView listView = (ListView) findViewById(R.id.listview2);
listView.setAdapter(adapter);