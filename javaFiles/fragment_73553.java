runOnUiThread(new Runnable(){
    @Override
    public void run() {
        this.discover.removeFriendPosition();
        this.discover.drawFriendPosition(this.getBaseContext());
    }
});