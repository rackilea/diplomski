myRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String finalBmi = (String)dataSnapshot.getValue();
        showBMI.setText( ("BMI:   " + finalBmi));
    }