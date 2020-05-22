private class NoSSLv3SSLSocket extends DelegateSSLSocket {

    private NoSSLv3SSLSocket(SSLSocket delegate) {
        super(delegate);
    }

    @Override
    public void setEnabledProtocols(String[] protocols) {
        super.setEnabledProtocols(new String[]{"TLSv1.2"}); // force to use only TLSv1.2 here
    }
}