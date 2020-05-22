shiftSwapDb.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        if (dataSnapshot.exists()) {
            SwapDetails swapDetails = dataSnapshot.getValue(SwapDetails.class);
            if (swapDetails.getSwapperID().equals(fromID)) {

hasSwaperID = true;
            }
        }
    }