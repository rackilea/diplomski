private boolean writeData(byte[] data)
{
    int retry = 0;
    while (usbDeviceConnection.bulkTransfer(writeEndpoint, data, data.length, 5000) != data.length)
    {
        retry++;
        if (retry > 4)
        {
            return false;
        }
    }
    return true;
}