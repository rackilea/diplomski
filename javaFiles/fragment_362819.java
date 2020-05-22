button.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        Intent act = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(act);
    }
});