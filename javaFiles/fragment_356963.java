findViewById(R.id.buttonFoo).setOnClickListener(new OnClickListener() {
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), Foo.class);
        startActivity(i);
    }
});