r.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

                        Map<String,Object> newPost=(Map<String,Object>)snapshot.getValue();

                        String name1 = String.valueOf(newPost.get("Author"));
                        String message1 = String.valueOf(newPost.get("Title"));


                        System.out.println("Message: " + newPost.get("Author"));
                        System.out.println("Name: " + newPost.get("Title"));

                    }
                });