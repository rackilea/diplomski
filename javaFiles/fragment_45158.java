public int getUserid(String username) {
        final ValueBox<Integer> userid = new ValueBox<Integer>();

        connection.call("getUserid", new Responder() {
                public void onResult(final int result) {
                        System.out.println("userid: " + result);
                        userId.setValue(result);
                        //how to assign received value to userid and return it?
                }
        }, username);

        //wait for response
        while (userid.isEmpty()) {
                try{
                        Thread.sleep(100);
                } catch (Exception e) {}
        }

      return userid.getValue();
}