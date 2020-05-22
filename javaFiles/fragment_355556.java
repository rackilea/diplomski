class DeviceManager extends AsyncTask<String, Void, List<String>> {

    private ConnectionCompleteListener listener;

    public interface ConnectionCompleteListener {
        void onSuccess(List<String> deviceList);

        // if you need to know reason for failure you can add
        // parameter to onFailure
        void onFailure();
    }

    public DeviceManager(ConnectionCompleteListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<String> doInBackground(String... params) {
        List<String> deviceList = new ArrayList<>();
        String networkIP = params[0];
        try {
            InetAddress address;
            Log.i("NetworkIPgetDeviceList", networkIP);

            String deviceIP = networkIP;
            for (int i = 0; i < 255; i++) {
                address = InetAddress.getByName(deviceIP += "" + i);
                if (address.isReachable(2000)) {
                    Log.i("Devicefound", deviceIP);
                    deviceList.add(deviceIP);
                }
                deviceIP = networkIP;
            }
        } catch (IOException e) {
            deviceList = null;
            e.printStackTrace();
        }
        return deviceList;
    }

    @Override
    protected void onPostExecute(List<String> deviceList) {
        if (deviceList == null) {
            this.listener.onFailure();
        } else {
            this.listener.onSuccess(deviceList);
        }
    }
}