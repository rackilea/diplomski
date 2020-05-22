DatabaseReference reference = 
database.getReference("UserInfo").child("gameStats");
reference.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {

    // You have to use key-value pairs like in ContentValues
    // To loop through the values

    for (DataSnapshot snap: dataSnapshot.getChildren()) {
     snap.child("child") yourObeject.getValue(youObject.Class) 

    }

}