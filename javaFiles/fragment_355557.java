new DeviceManager(new DeviceManager.ConnectionCompleteListener
            () {
        @Override
        public void onSuccess(List<String> deviceList) {

        }

        @Override
        public void onFailure() {

        }
    }).execute("YOUR_NETWORK_IP");