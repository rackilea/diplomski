public void addOrganisation(View view){
       ListView myOrgsListView = findViewById(R.id.myOrgsListView);
        db.collection("organisations").whereEqualTo("user", mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    ArrayList<String> myOrgs = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()){

                        Log.i(TAG, document.getId() + " => " + document.get("organisation"));

                        myOrgs.add(document.get("organisation").toString())

                        Log.i("ARRAY LIST", myOrgs.toString());

                    }
                     ArrayAdapter<String> orgArrayAdapter = new ArrayAdapter<String>(AppSettings.this, android.R.layout.simple_list_item_1, myOrgs);
                        myOrgsListView.setAdapter(orgArrayAdapter);
                } else {
                    Log.i(TAG, "Error getting documents:", task.getException());
                }
            }
        });

    }