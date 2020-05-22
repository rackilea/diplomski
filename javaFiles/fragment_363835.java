clientCompletedRegistrationValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot emailSnapshot : dataSnapshot.getChildren()) {

                    Log.d("Adding", emailSnapshot.getValue().toString() + " to emailAddressList");
                    emailAddressList.add(emailSnapshot.getValue().toString());
                    Log.d("in onDataChange", "emailAddressList is:" + Arrays.toString(emailAddressList.toArray()));
                }
                    Log.d("in onActivityResult","user is:"+user.getDisplayName());
                    Log.d("in onActivityResult","emailAddressList is:"+ Arrays.toString(emailAddressList.toArray()));
                    Log.d("in onActivityResult","user.getEmail() is"+ emailAddressList.contains(user.getEmail()));

                    if(emailAddressList.contains(user.getEmail())) {
                        Toast.makeText(NavDrawerActivity.this, "You're signed in again", Toast.LENGTH_SHORT).show();
                    } else {
                        // Gets photoUrl when Google+ photo is set, otherwise returns null. Appending '?sz=100' at end gets a photo of 100x100 px
                        String photoUrl = user.getPhotoUrl() != null ? user.getPhotoUrl().toString()+"?sz=100": null;
                        Toast.makeText(NavDrawerActivity.this, "You're signed in for the first time", Toast.LENGTH_SHORT).show();

                        Client client = new Client(user.getDisplayName(),0,photoUrl,user.getDisplayName().replaceAll("\\s+","").toLowerCase(),"Brooklyn,NY");
                        // User has just created an account, save his/her details to the 'Clients' child
                        clientDatabaseReference.push().setValue(client);
                        // When user is registering for the first time, pushes his/her email ID to the 'Completed Registration' child
                        clientCompletedRegistrationReference.push().setValue(user.getEmail());
                    }

                }
            };