db.collection(COLLECTION_KEY).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        List<Missions> mMissionsList = new ArrayList<>();
        if(task.isSuccessful()){
            for(QueryDocumentSnapshot document : task.getResult()) {
                Missions miss = document.toObject(Missions.class);
                mMissionsList.add(miss);
            }
            ListView mMissionsListView = (ListView) findViewById(R.id.missionList);
            MissionsAdapter mMissionAdapter = new MissionsAdapter(this, mMissionsList);
            mMissionsListView.setAdapter(mMissionAdapter);
        } else {
            Log.d("MissionActivity", "Error getting documents: ", task.getException());
        }
    }
});