public static void main(String[] args) throws Exception {
    Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/29553461");

    /*
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("puf", "Frank van Puffelen");
    map.put("frank", "Frank van Puffelen");
    map.put("david", "David East");
    map.put("east", "David East");
    ref.setValue(map);
    */

    Query refQ = ref.orderByValue().equalTo("Frank van Puffelen");
    refQ.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            System.out.println("Child added: "+dataSnapshot.getKey()+": "+dataSnapshot.getValue());
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) { }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

        @Override
        public void onCancelled(FirebaseError firebaseError) { }
    });

    Console console = System.console();
    if (console != null) {
        console.format("Press ENTER to process.\n");
        console.readLine();
    }
    else {
        System.out.println("Sleeping for 5 seconds, in hopes that everything is done by then.");
        Thread.sleep(5000);
    }
}