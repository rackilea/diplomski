myListView.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View view, int position, long id) {
                String item = (String) myListView.getAdapter().getItem(position);

                Intent intent = new Intent(getBaseContext(), MyActivity.class);
                intent.putExtras("name", item);
                startActivity(intent);
        }
    });