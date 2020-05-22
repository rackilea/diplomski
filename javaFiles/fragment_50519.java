String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
usersRef.document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                String type = document.getString("type");
                if(type.equals("student")) {
                    startActivity(new Intent(MainActivity.this, Student.class));
                } else if (type.equals("teacher")) {
                    startActivity(new Intent(MainActivity.this, Teacher.class));
                }
            }
        }
    }
});