yourButton.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
    // TODO Auto-generated method stub
        Intent intent = new Intent(context, YourNewActivity.class);
        ((Activity) context).startActivityForResult(intent, resultCode);
    }
});