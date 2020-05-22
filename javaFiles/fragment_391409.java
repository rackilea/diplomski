private void call() {
makecall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number.getText().toString()));
        startActivity(intent);
    }
});
}