for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
        Contacts contacts =npsnapshot.getValue(Contacts.class);
        mcontacts.add(contacts);  // you miss this line
     }
        mAdapter = new UsersAdapter ( getApplicationContext () , mcontacts );
        recyclerView.setAdapter ( mAdapter );