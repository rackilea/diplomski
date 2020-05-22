String proxyHost = Config.prefs.get("PROXY_NAME", "localhost");
        int proxyPort = Config.prefs.getInt("PROXY_PORT", 1080);
        InetSocketAddress proxyAddr = new InetSocketAddress(proxyHost, proxyPort);
        Socket underlying = new Socket(new Proxy(Proxy.Type.SOCKS, proxyAddr));
        underlying.connect(new InetSocketAddress(getHost(), getPort()));
        socket = (SSLSocket) factory.createSocket(
                underlying,
                proxyHost,
                proxyPort,
                true);