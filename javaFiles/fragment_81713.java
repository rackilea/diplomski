protected void onStart() {
    super.onStart();

    ((YourApp) getApplication()).postCallbackFileAccess (
        YourApp.TOKEN_LOAD, new Runnable() {
            @Override
            public void run() {
                file_manager.load();
            }
    });
}

protected void onPause() {
    super.onPause();

    ((YourApp) getApplication()).postCallbackFileAccess (
        YourApp.TOKEN_SAVE, new Runnable() {
            @Override
            public void run() {
                file_manager.save();
            }
    });
}