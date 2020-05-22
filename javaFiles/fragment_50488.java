for (int i = 0; i < emails.size(); i++) {
 String email = emails.get(i);
 Log.d("interactor--email", email.trim());
 Log.d("interactor--last-emails", String.valueOf(emails).trim());

 queryReference(emailReference, carbonCopyReference, email.trim(), response, listener);
}

private void queryReference( DatabaseReference emailReference, DatabaseReference carbonCopyReference, String email, ConsultationResponse response, SendingMessageListener listener) {
    emailReference.orderByChild("email").equalTo(email).addChildEventListener(new ChildEventListener() { //.startAt(classmateEmails[i]).endAt(classmateEmails[i]+UF8FF)
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Log.d("interactor--snapshotKey", dataSnapshot.getKey());
            List<String> carbonUids = new ArrayList<>();
            carbonUids.add(dataSnapshot.getKey());
            Log.d("interactor--emailSnap", email);

            Log.d("interactor--carbonKey1", String.valueOf(carbonUids));
            Log.d("interactor--carbonSize1", String.valueOf(carbonUids.size()));

            for (int i = 0; i < carbonUids.size(); i++) {
                String carbonUid = carbonUids.get(i);
                Log.d("interactor--carbonLoop", carbonUid);
                carbonCopyReference.child(carbonUid).child(CONSULTATION_REQUESTS).push().setValue(response);
                if (i == (carbonUids.size() - 1)) { //i == (emails.size() - 1)
                    Log.d("interactor--finishLoop", "Loop finished.");
                    listener.onSuccess("Request Sent");
                    context.startActivity(new Intent(context, ConsultDepartmentsActivity.class));
                    ((Activity) context).finish();
                    ((Activity) context).overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
            }
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

}