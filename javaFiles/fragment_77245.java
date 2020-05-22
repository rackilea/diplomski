public void getListOfConnectedDevice() {
    final Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            macAddresses.clear();
            BufferedReader br = null;
            boolean isFirstLine = true;
            try {

                br = new BufferedReader(new FileReader("/proc/net/arp"));
                String line;

                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }

                    String[] splitted = line.split(" +");

                    if (splitted != null && splitted.length >= 4) {

                        String ipAddress = splitted[0];
                        String macAddress = splitted[3];

                        Node node = new Node(ipAddress, macAddress);
                        boolean isReachable = node.isReachable;
                        Log.d(TAG, "isReachable: " + isReachable);
                        if (isReachable) {
                            Log.d("Device Information", ipAddress + " : "
                                    + macAddress);
                            macAddresses.add(macAddress);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    thread.start();
}