Firebase.setAndroidContext(this);
        ref = new Firebase(Constants.FIREBASE_URL);
        try {
            ref.child("Root/Question/").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("!)@@>>", dataSnapshot.getKey() + " " + dataSnapshot.getValue() + " " + dataSnapshot.getChildren() + " " + dataSnapshot.getChildrenCount());
                    ArrayList<String> a = (ArrayList) dataSnapshot.getValue();
                    Log.e("!_@@", a.get(0) + ""); // use your counter value instead of 0
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }