newref.addValueEventListener(object: ValueEventListener {
 override fun onDataChange(dataSnapshot: DataSnapshot) {
        Log.d("ac1234","${dataSnapshot}")

    }

    override fun onCancelled(databaseError: DatabaseError) {
        Log.w(TAG, "loadPost:onCancelled", databaseError.toException())

    }
}