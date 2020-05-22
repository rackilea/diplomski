private static Integer UPDATE_COUNT = 0;
private static final String CHILD = "Example";
private final NotSureAboutType dbReference = getDatabaseReference();
private final SomeType uuid = getFirebaseAuthInstance().getCurrentUser().getUid();

final String UniqueID = getDatabaseReference().child("Example").push().getKey();

private void updateDB(final NotSureAboutType dbReference,
                      final SomeType uuid,
                      final String uniqueID,
                      final Object anyData,
                      final String year,
                      final Integer n) {
    String tmpYear = year;
    UPDATE_COUNT++;
    dbReference
            .child(CHILD)
            .child(uuid)
            .child(tmpYear)
            .child(UniqueID)
            .setValue(anyData)
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        listener.success(); // not sure what this does ?

                        if (UPDATE_COUNT <= n) {
                            updateDB(dbReference, uuid, uniqueID, anyData, (Integer.parseInt(tempyear) + 1), n);
                        }

                    }else {
                        listener.failure();
                    }
                }
            });
}