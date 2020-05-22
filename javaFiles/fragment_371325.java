public void getCoordinates(View view){
Button coordinates = (Button) findViewById(R.id.getCoordinates);
coordinates.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        getLocation = YourActivity.this.getIntent();
        extras = getLocation.getExtras();
        lat = extras.getDouble("lat");
        longi = extras.getDouble("longi");
    }
});
}