db.collection("students").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                Student student = document.toObject(Student.class);
                student.setActive(false); //Use the setter
                String id = document.getId();
                db.collection("students").document(id).set(student); //Set student object
            }
        }
    }
});