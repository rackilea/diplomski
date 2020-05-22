listResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Serializable selectedResult = (Serializable) parent.getItemAtPosition(position);
        Intent intent = new Intent();
        intent.putExtra("result", selectedResult);
        intent.setClass(SearchResultsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
});