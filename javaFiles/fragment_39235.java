database = FirebaseDatabase.getInstance();
    myRef = database.getReference("complaints");
    Personal_RecyclerAdapter recyclerAdapter = new Personal_RecyclerAdapter(list,list2, getContext());
    RecyclerView.LayoutManager recyce = new GridLayoutManager(getContext(),1);
    recyclerView.setLayoutManager(recyce);
    recyclerView.setItemAnimator( new DefaultItemAnimator());
    recyclerView.setAdapter(recyclerAdapter);
    list = new ArrayList<Blog>();
    list2 = new ArrayList<Complainee>();

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            try{

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    final Blog value = dataSnapshot1.getValue(Blog.class);
                    Boolean Posted = value.getPosted();
                    String complaint_type = value.getComplaintType();

                    if(complaint_type.equals("Personal Complaint")) {

                        final int ComplaintNo = value.getComplaintNo();
                        String Description = value.getDescription();
                        String Date = value.getDate();
                        String MediaURL = value.getMediaURL();
                        String Time = value.getTime();
                        String Address = value.getAddress();

                        final Blog fire = new Blog();
                        fire.setComplaintNo(ComplaintNo);
                        fire.setDescription(Description);
                        fire.setDate(Date);
                        fire.setMediaURL(MediaURL);
                        fire.setTime(Time);
                        fire.setAddress(Address);
                        fire.setComplainee_Name(value.getComplainee_Name());



                       // Read from the database for COMPLAINEE
                        DatabaseReference myRef2 = database.getReference("complainee").child(String.valueOf(ComplaintNo));

                        myRef2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnap) {

                                Complainee cm = dataSnap.getValue(Complainee.class);

                                String n = cm.getName();

                                final Complainee fire2 = new Complainee();
                                fire2.setName(n);
                                fire2.setAddress("Address");
                                list2.add(fire2);
                                // Notify to your recyclerview that for the new data
                                recyclerAdapter.notifyDataSetChanged();

                            }


                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        list.add(fire);
                        // Notify to your recyclerview that for the new data
                        recyclerAdapter.notifyDataSetChanged();

                    }

                }




            }catch (Exception e){

                Toast.makeText(getContext(), "::ERROR   " + e.toString(), Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });