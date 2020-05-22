public String getLocalIpAddress() {
try {
    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
        NetworkInterface intf = en.nextElement();
        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
            InetAddress inetAddress = enumIpAddr.nextElement();
            if (!inetAddress.isLoopbackAddress()) {
                String ip = inetAddress.getHostAddress();
                Log.i(TAG, "***** IP="+ ip);
                return ip;
            }
        }
    }
} catch (SocketException ex) {
    Log.e(TAG, ex.toString());
}
return null;
}