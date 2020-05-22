addButton.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = LayoutInflater
                        .from(getApplicationContext());
        View view = inflater.inflate(R.layout.job_row_layout, null);
        containerLayout.addView(view);

    }
});