@Override
protected void onNewIntent(Intent in) {
    super.onNewIntent(in);

    if(in.hasExtra("some_tag") && in.getExtra("some_tag") == true) {
        //Do Something Special
    }
}