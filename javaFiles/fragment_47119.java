update_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int time = Integer.parseInt(xxx.getEditText().getText().toString().trim());
                        String info = information.getEditText().getText().toString();
                        final long timeCountInMilliSeconds = time * 60 * 1000;

                        if (!TextUtils.isEmpty(info) && !TextUtils.isEmpty(String.valueOf(time))) {

                            progressBar.setVisibility(View.VISIBLE);

                new Timer().scheduleAtFixedRate(new TimerTask() {

                            @Override
                        public void run() {
                            //Called each time when 1000 milliseconds (1 second) (the period parameter)

                            update_ref = 
            FirebaseDatabase.getInstance().getReference().child("Event Halls").child("Ankobra One").child("Event Schedule");
                            final int finalTime = time;
                            update_ref.setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        final DatabaseReference ref = 
            FirebaseDatabase.getInstance().getReference().child("Event Halls").child("Ankobra One").child("Event Schedule");
                                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                        void onDataChanged(@NonNull DataSnapshot snapshot) {
                                              retrieve_ref.setValue("No event scheduled");


                                        }

                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                            Toast.makeText(AnkobraOneActivity.this, "Event Changed and scheduled for " + finalTime + " hours", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.INVISIBLE);
                                            myDialog.dismiss();
                                        }
                                    });
                              },
                    //Set how long before to start calling the TimerTask (in milliseconds)
                    0,
                    //Set the amount of time between each execution (in milliseconds)
                    timeCountInMilliSeconds);
                                } else

                                {
                                    Toast.makeText(AnkobraOneActivity.this, "Insert all details accordingly", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });