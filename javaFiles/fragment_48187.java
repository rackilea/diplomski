public static void connect () {
    if (needSSLsocket) {
        SSLSocket ssl = SslUtils.getSSLsocket(host, port, keystoreFile, keystorePass, pkPass);
        ssl.startHandshake();
        ...
        currentSocket = ssl;

        /* or:
        currentSocket = SslUtils.getSSLsocket(host, port, keystoreFile, keystorePass, pkPass);
        ((SSLSocket) currentSocket).startHandshake();
        ...
        */
    } else {
        currentSocket = new Socket(host, port);
    }
    ...
}