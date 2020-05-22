mDatabaseReference.child("0/"+"hotels").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        final List<Hotel> hotelList = new ArrayList<>();
        for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
            Hotel hotel = dataSnapshot.child(i + "").getValue(Hotel.class);
            hotelList.add(hotel);

            Log.d(TAG, hotel.getId() + "\n");
            Log.d(TAG, hotel.getCityId() + "\n");
            Log.d(TAG, hotel.getName() + "\n");
            Log.d(TAG, hotel.getRoomsAvailable() + "\n");
        }
        Log.d("TAG", hotelList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cities_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.Adapter adapter = new HotelAdapter(getApplicationContext(), hotelList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "onCreate:Failed to read hotelList.", databaseError.toException());

    }
});