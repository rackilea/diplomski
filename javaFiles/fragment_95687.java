mLEScanner = mBluetoothAdapter.getBluetoothLeScanner();
    // Set scan settings
    settings = new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_BALANCED).build();
    // Set device filter (null is allowed)
    filters = new ArrayList<ScanFilter>();

    // START SCAN FOR BLE DEVICES!
    scanLeDevice(true);