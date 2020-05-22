dbBillPaid.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        billPaidList.clear();


        for(DataSnapshot customerSnapshot : dataSnapshot.getChildren()){
            // Customer customer = customerSnapshot.getValue(Customer.class);
            BillPaid billPaid =  customerSnapshot.getValue(BillPaid.class);

            billPaidList.add(billPaid);
        }