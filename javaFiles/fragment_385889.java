titlesDatabaseReference.orderByChild("title").equalTo("the title you search for").
              addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Do whatever you want with the snapshot
                                }
                            }
                        }
                    });