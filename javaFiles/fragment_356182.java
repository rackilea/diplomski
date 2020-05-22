CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .retryPolicy(new ExponentialBackoffRetry(retryInitialWaitMs, maxRetryCount))
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs);
    /*
     * If authorization information is available, those will be added to the client. NOTE: These auth info are
     * for access control, therefore no authentication will happen when the client is being started. These
     * info will only be required whenever a client is accessing an already create ZNode. For another client of
     * another node to make use of a ZNode created by this node, it should also provide the same auth info.
     */
    if (zkUsername != null && zkPassword != null) {
        String authenticationString = zkUsername + ":" + zkPassword;
        builder.authorization("digest", authenticationString.getBytes())
                .aclProvider(new ACLProvider() {
                    @Override
                    public List<ACL> getDefaultAcl() {
                        return ZooDefs.Ids.CREATOR_ALL_ACL;
                    }

                    @Override
                    public List<ACL> getAclForPath(String path) {
                        return ZooDefs.Ids.CREATOR_ALL_ACL;
                    }
                });
    }

CuratorFramework client = builder.build();