databaseStatus.child(uid).child(key).addValueEventListener(new ValueEventListener() {

   @Override
    public void onDataChange(DataSnapshot snapshot) {



                OtherClass otherClass = snapshot.getValue(OtherClass.class);
                Log.d("Show", otherClass.getOname() == null ? "" : otherClass.getOname());
                list.add(otherClass);
            }