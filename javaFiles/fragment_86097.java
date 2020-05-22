dbBillPaid.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        billPaidList.clear();

            BillPaid billPaid =  dataSnapshot.getValue(BillPaid.class);

            billPaidList.add(billPaid);
        }