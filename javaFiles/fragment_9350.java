CartList = new ArrayList<>();
for (DataSnapshot ds : dataSnapshot.getChildren()) {
    for (DataSnapshot cart : ds.getChildren()) {
        CartList.add(cart.getValue(Cart.class));
    }
}