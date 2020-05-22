CountDownLatch latch = new CountDownLatch(1);
ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        System.out.println("onDataChange: " + dataSnapshot);
        latch.countDown();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("onCanceled: " + databaseError);
        latch.countDown();
    }
});
latch.await();