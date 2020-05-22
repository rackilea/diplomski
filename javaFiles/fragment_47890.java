edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,ActivityYouWantToStart.class);
        //Pass any extras if you want to.
        ((Activity)context).startActivityForResult(intent,REQUEST_CODE);
    }
});