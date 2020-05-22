public String getMacAddressFromIP(@NonNull String ipFinding)
{

    Log.i("IPScanning","Scan was started!");
    List<LocalDeviceInfo> antarDevicesInfos = new ArrayList<>();


    BufferedReader bufferedReader = null;

    try {
        bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitted = line.split(" +");
            if (splitted != null && splitted.length >= 4) {
                String ip = splitted[0];
                String mac = splitted[3];
                if (mac.matches("..:..:..:..:..:..")) {

                    if (ip.equalsIgnoreCase(ipFinding))
                    {
                        return mac;
                    }
                }
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally{
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return "00:00:00:00";
}