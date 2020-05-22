button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        notesView = new TextView(this);
        notesView.setText(editText.getText().toString());
        linearLayout.addView(notesView);
    }
});