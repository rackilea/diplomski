lisOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
      Intent itemInfo = new Intent(MainActivity.this, secondActivity.class);
      itemInfo.putExtra("Itemis",position); //position is INT value!!
      startActivity(itemInfo);
    }
});