public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        int allDuck = 0;

        for (DataSnapshot uids : dataSnapshot.child("DuckID").getChildren()) {

            String uidKeys = uids.getKey();

            if (uidKeys != null) {
                allDuck += (int) dataSnapshot.child("DuckID").child(uidKeys).child("stocks").getChildrenCount();                            
            }
        }
        textView.setText(allDuck " Rubber Duck");
    }