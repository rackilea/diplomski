firebaseFirestore.collection("videos")
    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            for (DocumentSnapshot document : task.getResult()) {
                List<String> products = (List<String>) document.get("products");
                for (String product : products) {
                    Log.d("TAG", product);
                }
            }
        }
    });