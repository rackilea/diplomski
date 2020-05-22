private static final String serverIp;
static {
    String addressString = null;
    try
    {
        InetAddress address = InetAddress.getLocalHost();
        addressString = address.getHostAddress();
    } catch (Exception e)
    {
        logger.error("Exception while attempting to determine local ip address",e);
    }

    if (addressString != null) serverIp = addressString;
    else serverIp = "unknown";
}