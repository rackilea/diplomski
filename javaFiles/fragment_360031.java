listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public boolean onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //here you can use the position to determine what checkbox to check
            //this assumes that you have an array of your checkboxes as well. called checkbox
            checkBox[position].setChecked(!checkBox.isChecked());
        }
    });