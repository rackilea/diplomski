import java.util.HashMap;

public class DeviceHolder{
    private BluetoothDevice device;
    private int rssi;


    public DeviceHolder(BluetoothDevice device, int rssi){
        this. device = device;
        this.rssi = rssi;
    }
    public String getAddress() {
        return device.getAddress();
    }
    public String getName() {
        return device.getName();
    }
    public void setRSSI(int rssi){
        this.rssi = rssi;
    }
    public int getRSSI() {
        return rssi;
    }
}

private class LeDeviceListAdapter extends BaseAdapter {
    private ArrayList<BluetoothDevice> mLeDevices;
    private ArrayList<DeviceHolder> mLeHolders;
    private LayoutInflater mInflator;
    private HashMap<String, DeviceHolder> mLeDevicesRssi;

    public LeDeviceListAdapter() {
        super();
        mLeDevices = new ArrayList<BluetoothDevice>();
        mLeHolders = new ArrayList<DeviceHolder>();
        mLeDevicesRssi = new HashMap<String, DeviceHolder>();
        mInflator = DeviceScanActivity.this.getLayoutInflater();
    }

    public void addDevice(DeviceHolder deviceHolder, int rssi) {
        String address = deviceHolder.device.getAddress();
       if(!mLeDevices.contains(deviceHolder.device)) {
           DeviceHolder cDeviceHolder = new DeviceHolder(deviceHolder.device, deviceHolder.rssi);
           cDeviceHolder.setRSSI(rssi);
           mLeDevicesRssi.put(address, cDeviceHolder);
           mLeDevices.add(cDeviceHolder.device);
           mLeHolders.add(cDeviceHolder);
       }
       else if(mLeDevices.contains(deviceHolder.device)) {
           mLeDevicesRssi.get(address).setRSSI(rssi);
       }
       mLeDeviceListAdapter.notifyDataSetChanged();
    }
....
}

 private BluetoothAdapter.LeScanCallback mLeScanCallback =
        new BluetoothAdapter.LeScanCallback() {

            @Override
            public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
                DeviceHolder deviceHolder = new DeviceHolder(device, rssi);
                final int new_rssi = rssi;
                runOnUiThread(new DeviceAddTask( deviceHolder, new_rssi ) );
            }
        };

class DeviceAddTask implements Runnable {
    DeviceHolder deviceHolder;

    public DeviceAddTask( DeviceHolder deviceHolder, int rssi ) {
        this.deviceHolder = deviceHolder;
        this.deviceHolder.rssi = rssi;
    }

    public void run() {
        mLeDeviceListAdapter.addDevice(deviceHolder, deviceHolder.rssi);
        mLeDeviceListAdapter.notifyDataSetChanged();
    }
}