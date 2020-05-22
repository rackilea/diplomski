listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            alert.show();
            s = listView.getItemAtPosition(position).toString();
        }
    });