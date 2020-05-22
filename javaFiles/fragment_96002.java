final LinearLayout lb1 = findViewById(R.id.b_title1a);
final TextView b1 = findViewById(R.id.b_title1);
b1.setTextColor(getResources().getColor(R.color.colorPrimary));
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (lb1.getVisibility() == View.VISIBLE) {
            lb1.setVisibility(View.GONE);
            b1.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            lb1.setVisibility(View.VISIBLE);
            b1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
});