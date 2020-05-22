connection = new XMPPTCPConnection(
        XMPPTCPConnectionConfiguration.builder()
                .setServiceName("192.168.1.6")
                .setUsernameAndPassword("ehsan", "123")
                .setPort(9090)
                .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                .setCompressionEnabled(false)
                .setDebuggerEnabled(true)
                .build());