@Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    owner o = data.getValue(owner.class);
                    ownerlist.add(o);
                }
                list.setAdapter(adapter);
                adapter.addData(ownerlist);

            }