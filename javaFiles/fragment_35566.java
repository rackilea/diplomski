listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor data = bookmarkDB.getListContents();
            int i = 0;
            while(data.moveToNext()){
                if(i == position){
                    break;
                }
                i++;
            }
            int rowsDeleted = bookmarkDB.deleteSpecificContent(data.getInt(0));
            //again, handle if rowsDeleted != 1 if you want
            return true;
        }
    });