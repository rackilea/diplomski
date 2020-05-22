listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String string = parent.getAdapter().getItem(position);
            Intent intent = new Intent(this, nextActivity.class);
            intent.putExtra("text", string);
            startActivity(intent);
        }
    });