@Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.getValue() != null) {
                    Message newMessage = dataSnapshot.getValue(Message.class);
                    if (newMessage != null) {
                        for (int i = 0; i < myArrayList().size(); i++) {
                            if (myArrayList().get(i).timestamp == newMessage.timestamp) {
                                myArrayList().remove(i);
                                myArrayList().add(i, newMessage);
                                break;
                            }
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }