tampil.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        readData(new MyCallback() {
            @Override
            public void onCallback(LatLng newlocation) {
                //Do what you need to do with newlocation
            }
        });
    }
});