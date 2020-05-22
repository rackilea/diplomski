setCallbackForSomething(new Callback() {
    public void onCall() {
        // ...
        res.complete(5); // or handle exception
    }
});