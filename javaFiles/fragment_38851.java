public void myMethod() {

    ArrayList<String> theList = new ArrayList<>();


    Cursor data = db.getListViewAccountrequestinfo(spnpending.getSelectedItem().toString());
    if (data.getCount() == 0) {

    } else {


        if (data.moveToFirst()) {
            do {
                theList.add("Username: " + spnpending.getSelectedItem());
                theList.add("First name: " + data.getString(1));
                theList.add("Last name: " + data.getString(2));
                theList.add("Contact: " + data.getString(3));
                theList.add("Email: " + data.getString(4));

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                lvinfo.setAdapter(listAdapter);

            } while (data.moveToNext());
        }
    }