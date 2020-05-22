ArrayList<String> arrayUsedToCreateTheAdapter = new ArrayList<>();

 @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(resultCode == RESULT_OK && data.hasExtra("newItem")){
       arrayUsedToCreateTheAdapter.add(data.getStringExtra("newItem"););
       adapter.notifyDataSetChanged();
    }
}