private void onSessionStateChange(Session session, SessionState state, Exception exception) {
    if (state.isOpened()) { 
        Log.i(TAG, "Logged in..."); 
    } else if (state.isClosed()) {
       Log.i(TAG, "Logged out..."); 
   }
}