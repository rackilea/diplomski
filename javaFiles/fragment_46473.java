Button button = (Button)findViewById(R.id.buttonId);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        TextView text = (TextView)findViewById(R.id.DeText);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,text.getTextSize()-1);
    }
});