sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                if(!messageText.equals("")){

                    map=new messageModel(messageText,userId);
                    reference1.child(""+n).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                reference2.child(""+n2).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {
                                            messageArea.setText("");
                                        }

                                    }
                                });
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"server problem try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        try
        {
            reference1.addChildEventListener(new com.google.firebase.database.ChildEventListener() {
                @Override
                public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                    map = dataSnapshot.getValue(messageModel.class);
                    String message = map.myMessage;
                    String userName = map.user;

                    if(userName.equals(userId)){
                        addMessageBox("You:\n" + message, 1);
                    }
                    else{
                        addMessageBox("USER:\n" + message, 2);
                    }
                }

                @Override
                public void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"error:"+e,Toast.LENGTH_SHORT).show();
        }