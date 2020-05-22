private void share() {
    handler.post(new Runnable(){
    @Override
    public void run() {
        // ... create intent
        startActivity(intent);
    }
}