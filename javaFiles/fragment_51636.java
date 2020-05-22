lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String itemName = (String) lv.getItemAtPosition(position);
            Intent intent = new Intent(currentActivity.this,newActivity.class);
            intent.putExtra("some_string", itemName);
            startActivity(intent);
        }               
  }