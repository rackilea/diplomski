View[] views = {
    findViewById(R.id.row1),
    findViewById(R.id.row2),
    //etc...
};

for (View v : views) {
    v.setOnClickListener(this);
}