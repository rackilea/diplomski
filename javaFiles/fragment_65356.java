bt_devices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String deviceName = ((TextView)view).getText().toString();
        String deviceMac = filterDevices.get(deviceName);
        Log.d("select", deviceName+":"+deviceMac);
    }
});