if (isConnectedToServer("http://yourserver.com", 60)) {
   new AlertDialog.Builder(this)
      .setTitle("Connected")
      .setMessage("You are connected to server")
      .create().show();
} else {
   new AlertDialog.Builder(this)
      .setTitle("Not Connected")
      .setMessage("You are not connected to server")
      .create().show();
}