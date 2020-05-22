public static long getActualServerTime() {
    String TIME_SERVER = "de.pool.ntp.org";   
    NTPUDPClient timeClient = new NTPUDPClient();
    InetAddress inetAddress;
    long returnTime = 0;

    try {
        inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
    } catch (Exception e) {
        e.printStackTrace();
    } catch (Throwable t) {
        t.printStackTrace();
    }

    return returnTime;
}