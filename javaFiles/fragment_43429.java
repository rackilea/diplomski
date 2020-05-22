chk1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        chk1.setChecked(true);
        chk2.setChecked(false);
    }
});
chk2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        chk2.setChecked(true);
        chk1.setChecked(false);
    }
            });