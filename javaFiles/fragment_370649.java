public View.OnClickListener searchStation = new View.OnClickListener() {
@Override
public void onClick(View v) {
    DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
    String searchString= searchText.getText().toString();

    String usethis = dbHelper.ifExistIn(searchString);

    list.add(usethis);
    arrayAdapter= new ArrayAdapter<String>(SearchAndReview.this, android.R.layout.simple_list_item_1, list);

    listView.setAdapter(arrayAdapter);
}
};