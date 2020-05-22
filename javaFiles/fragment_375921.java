class MySSLConnectionSocketFactory extends SSLConnectionSocketFactory {
    @Override
    protected void prepareSocket(SSLSocket socket) throws IOException {
        System.out.println("Supported Ciphers" + Arrays.toString(socket.getSupportedCipherSuites()));
        System.out.println("Supported Protocols" + Arrays.toString(socket.getSupportedProtocols()));
        System.out.println("Enabled Ciphers" + Arrays.toString(socket.getEnabledCipherSuites()));
        System.out.println("Enabled Protocols" + Arrays.toString(socket.getEnabledProtocols()));
    }
}