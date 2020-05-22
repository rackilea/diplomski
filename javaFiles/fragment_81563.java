ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {

        fridaySteps = snapshot.child("Fri").getValue(String.class);
        thursdaySteps = snapshot.child("Thu").getValue(String.class);
        wednesdaySteps = snapshot.child("Wed").getValue(String.class);
        tuesdaySteps = snapshot.child("Tue").getValue(String.class);
        mondaySteps = snapshot.child("Mon").getValue(String.class);

        mDataset[2] = ("Fri      "+fridaySteps);
        mDataset[3] = ("Thu      "+thursdaySteps);
        mDataset[4] = ("Wed      "+wednesdaySteps);
        mDataset[5] = ("Tue      "+tuesdaySteps);
        mDataset[6] = ("Mon      "+mondaySteps);

        printData();

    }
    @Override public void onCancelled(FirebaseError error) { }
});

...

private void printData() {
    System.out.println("Friday Steps: "+fridaySteps);
}