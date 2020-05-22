viewHolder.submitText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                TrempData tremp = getItem(position);
                                if (ds.getKey().toString().equals(tremp.get_key())) {
                                    viewHolder.name.setEnabled(false);
                                    String new_name = viewHolder.name.getText().toString();
                                    viewHolder.name.setBackground(new ColorDrawable(TRANSPARENT));
                                    viewHolder.submitText.setVisibility(View.GONE);
                                    data.set_name(new_name);
                                    mDatabase.child(ds.getKey().toString()).child("_name").setValue(new_name);
                                    notifyDataSetChanged();
                                    //Toast.makeText(getContext(),"הטרמפ עודכן בהצלחה" + position,Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            });