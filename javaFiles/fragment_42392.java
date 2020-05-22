View myClickableView = findViewById(R.id.myView);
myClickableView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        clear(v);
    }
});

public void clear(View v) {
        // do something
}