private final BroadcastReceiver brBluetoothScanningLooper=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                if(deviceFound==false) {
                    bluetoothAdapter.cancelDiscovery();
                    bluetoothAdapter.startDiscovery();
                }
            }
        }

    };


    private final BroadcastReceiver brNearbyBluetoothDevices=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                String deviceName=device.getName();
                String deviceHardwareAddress=device.getAddress();
                int rssi=intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);

                if(bondedList.contains(deviceHardwareAddress)){

                    if(!trackerList.contains(deviceHardwareAddress)){
                        if(trackerList.isEmpty()){
                            MAC=deviceHardwareAddress;
                        }
                        trackerList.add(deviceHardwareAddress);
                        rssiList.add(String.valueOf(rssi));
                        displayList.add(deviceName+"  "+rssi);
                        arrayAdapter.notifyDataSetChanged();
                        lv.setAdapter(arrayAdapter);
                    }
                    if(trackerList.contains(deviceHardwareAddress)){
                        rssiList.set(trackerList.indexOf(deviceHardwareAddress), String.valueOf(rssi));
                        displayList.set(trackerList.indexOf(deviceHardwareAddress),deviceName+"   "+(rssiList.get(trackerList.indexOf(deviceHardwareAddress))));
                        arrayAdapter.notifyDataSetChanged();
                       lv.setAdapter(arrayAdapter);
                    }
                }
}
};