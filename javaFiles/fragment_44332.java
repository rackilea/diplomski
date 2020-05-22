listView.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View view,
          int position, long id) {
        Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
            + id);
        SomeItem item = items.get(position); // specific item
      }
    });