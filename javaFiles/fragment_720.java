mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ProductEntity upload = postSnapshot.getValue(ProductEntity.class);
                    productList.add(upload);
                }

                productsRecyclerAdapter = new ProductsRecyclerAdapter(productList, CategoryActivity.this);
                products.setAdapter(productsRecyclerAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                NestedScrollView root_layout = findViewById(R.id.category_root_layout);
                Snackbar.make(root_layout, "Internal Error!!", Snackbar.LENGTH_SHORT).show();
            }
        });