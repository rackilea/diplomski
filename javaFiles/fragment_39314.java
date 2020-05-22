final BluetoothArrayAdapter arrayAdapter = new BluetoothArrayAdapter(MainActivity.this, R.layout.your_bluetooth_layout);
arrayAdapter.addAll(mBluetoothAdapter.getBondedDevices());
lv.setAdapter(arrayAdapter);

lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            bluetoothChatService.start();
            bluetoothChatService.connect(arrayAdapter.getItem(i));
        }
    });