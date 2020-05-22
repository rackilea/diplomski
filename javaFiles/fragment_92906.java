listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("data_to_pass", some_data); //If needed
            startActivity(intent);
        }
    });