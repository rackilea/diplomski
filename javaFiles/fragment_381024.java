public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    String title = ((SingleRow) adapterView.getItemAtPosition(i)).title;
    Intent intent = new Intent(getContext(), ActivityB.class);
    intent.putExtra(TITLE, title);
    startActivity(intent);
}