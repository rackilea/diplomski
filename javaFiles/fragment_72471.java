firstQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<ProductModel> list = new ArrayList<>();
            for (DocumentSnapshot document : task.getResult()) {
                ProductModel productModel = document.toObject(ProductModel.class);
                list.add(productModel);
            }
            ArrayAdapter<ProductModel> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);
            lastVisible = task.getResult().getDocuments().get(task.getResult().size() - 1);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Query nextQuery = productsRef.orderBy("productName", Query.Direction.ASCENDING).startAfter(lastVisible).limit(3);
                    nextQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> t) {
                            if (t.isSuccessful()) {
                                for (DocumentSnapshot d : t.getResult()) {
                                    ProductModel productModel = d.toObject(ProductModel.class);
                                    list.add(productModel);
                                }
                                arrayAdapter.notifyDataSetChanged();
                                lastVisible = t.getResult().getDocuments().get(t.getResult().size() - 1);
                            }
                        }
                    });
                }
            });
        }
    }
});