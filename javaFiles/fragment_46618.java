UsbRequest request = null;
synchronized(_outputLock)
{
    // requestWait() and request.queue() appear not to be thread-safe.
    request = _connection.requestWait();
}