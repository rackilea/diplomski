Intent in = getIntent();
if(in != null) {
    int rssi = in.getIntExtra("RSSI", -1);
    if(rssi < 0)
        wifi_check.setText(""+rssi);
    else
        wifi_check.setText("Unknown");
}