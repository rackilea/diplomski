@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
     for(DataSnapshot data : dataSnaphot.getChildren()){

            String photoKey = data.getKey();
            Log.d(TAG, "onDataChange: photo key is " + photoKey);

    } }