/**
 * Streaming transports save responses on the client side and don't free
 * memory used by delivered messages. Such transports need to recycle the
 * connection once in a while. This property sets a minimum number of bytes
 * that can be send over a single HTTP streaming request before it will be
 * closed. After that client will open a new request. Setting this value to
 * one effectively disables streaming and will make streaming transports to
 * behave like polling transports.
 * <p>The default value is 128K (i.e. 128 * 1024).
 */
public SockJsServiceRegistration setStreamBytesLimit(int streamBytesLimit) {
    this.streamBytesLimit = streamBytesLimit;
    return this;
}