/**
 * The number of server-to-client messages that a session can cache while waiting for
 * the next HTTP polling request from the client. All HTTP transports use this
 * property since even streaming transports recycle HTTP requests periodically.
 * <p>The amount of time between HTTP requests should be relatively brief and will not
 * exceed the allows disconnect delay (see
 * {@link #setDisconnectDelay(long)}), 5 seconds by default.
 * <p>The default size is 100.
 */
public SockJsServiceRegistration setHttpMessageCacheSize(int httpMessageCacheSize) {
    this.httpMessageCacheSize = httpMessageCacheSize;
    return this;
}