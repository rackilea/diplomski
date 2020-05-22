public void onResume() {
    // bla
    BLEConnection bleConnection = BLEConnection.getInstance(); 
    bleConnection.addListener(this);
}

public void onPause() {
    // bla
    BLEConnection bleConnection = BLEConnection.getInstance(); 
    bleConnection.removeListener(this);
}