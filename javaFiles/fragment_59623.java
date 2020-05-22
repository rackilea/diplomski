userMenuRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            double total = 0;
            for (QueryDocumentSnapshot document : task.getResult()) {
                double itemCost = document.getDouble("itemCost");
                total += itemCost;
            }
            Log.d("TAG", String.valueOf(total));
        }
    }
});