listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            TextView textView = (TextView) view.findViewById(R.id.text_view);
            final Integer which_item = (Integer) textView.getTag();    //Assuming you stored the ID as an Integer
            int rowsDeleted = bookmarksDB.deleteSpecificContent(which_item);
            if(rowsDeleted == 0){  //should be 1, since we're deleting by Primary Key
                //if you would like like, handle if nothing was deleted
            }
            return true;
        }
    });