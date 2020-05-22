LinearLayout top = (LinearLayout)findViewById(R.id.top);
for (int i = 0; i < num_of_rows; i++) {
    LayoutInflater inflater = LayoutInflater.from(this);
    LinearLayout row = (LinearLayout)inflater.inflate(R.layout.row, null);    
    // ... dynamically change values as needed
    top.addView(row);
}