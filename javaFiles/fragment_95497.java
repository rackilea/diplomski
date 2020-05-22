FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference propertiesRef = rootRef.collection("Properties");
CollectionReference customersRef = rootRef.collection("Customers");
customersRef.whereEqualTo("customerId", customerId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                String customerName = document.getString("name");
                propertiesRef.whereEqualTo("customerId", customerId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                propertiesRef.document(doc.getId()).update("customer", customerName);       
                            }
                        }
                    }
                });
            }
        }
    }
});