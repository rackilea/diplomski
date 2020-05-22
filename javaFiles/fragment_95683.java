playBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // You can't use just "this", pass the class instance.
        listener.buttonClicked(MyFragmentClassName.this, v);
    }
});