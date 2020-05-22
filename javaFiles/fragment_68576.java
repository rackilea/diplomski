private fun firebasecall() {
        var module = modulesDocumentIds.get(index)
//place your firestore call here
        firebaseFirestore.collection("Users")
            .document(userDocumentId)
            .collection("Courses")
            .document(courseDocumentId)
            .collection("Modules")
            .document(moduleId)
            .collection("Lessons")
            .orderBy("lesson_number",Query.Direction.ASCENDING)
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull (Task<QuerySnapshot>) task) {
                    index++
                    if (index < modulesDocumentIds.size) {
                        firebasecall()
                    } else {
                        //loop completes
                    }

                });

            }
    }