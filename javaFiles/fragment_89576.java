public final class RequestKey {

    private final Long userid;
    private final String deviceid;
    private final String flowid;
    private final int clientid;
    private final long timeout;
    private final boolean abcFlag;
    private final boolean defFlag;
    private final Map<String, String> baseMap;

    private RequestKey(FinalBuilder builder) {
        this.userid = builder.userid;
        this.deviceid = builder.deviceid;
        this.flowid = builder.flowid;
        this.clientid = builder.clientid;
        this.abcFlag = builder.abcFlag;
        this.defFlag = builder.defFlag;
        this.baseMap = builder.baseMap.build();
        this.timeout = builder.timeout;
    }
    public static class Builder {
        public Builder1 clientId(int clientid) {
            checkArgument(clientid > 0, "clientid must not be negative or zero");
            return new Builder1(clientid);
        }
    }
    public static class Builder1 {
        private final int clientid;

        Builder1(int clientid){
            this.clientid = clientid;
        }
        public FinalBuilder userId(long userid) {
            checkArgument(userid > 0, "userid must not be negative or zero");
            FinalBuilder builder = new FinalBuilder(clientid);
            return builder.setUserId(userid);
        }

        public FinalBuilder deviceId(String deviceid) {
            checkNotNull(deviceid, "deviceid cannot be null");
            checkArgument(deviceid.length() > 0, "deviceid can't be an empty string");
            FinalBuilder builder = new FinalBuilder(clientid);
            return builder.setDeviceId(deviceid);
        }

        public FinalBuilder flowId(String flowid) {
            checkNotNull(flowid, "flowid cannot be null");
            checkArgument(flowid.length() > 0, "flowid can't be an empty string");
            FinalBuilder builder = new FinalBuilder(clientid);
            return builder.setFlowId(flowid);
        }
    }

    public static class FinalBuilder {
        private final int clientid;
        private Long userid = null;
        private String deviceid = null;
        private String flowid = null;
        private long timeout = 200L;
        private boolean abcFlag = false;
        private boolean defFlag = true;
        private ImmutableMap.Builder<String, String> baseMap = ImmutableMap.builder();

        FinalBuilder(int clientId) {
            this.clientid = clientId;
        }


        FinalBuilder setUserId(long userid) {
            this.userid = userid;
            return this;
        }

        FinalBuilder setDeviceId(String deviceid) {
            this.deviceid = deviceid;
            return this;
        }

        FinalBuilder setFlowId(String flowid) {
            this.flowid = flowid;
            return this;
        }
        public FinalBuilder userId(long userid) {
            checkArgument(userid > 0, "userid must not be negative or zero");
            this.userid = Long.valueOf(userid);
            this.userid = userid;
            return this;
        }

        public FinalBuilder deviceId(String deviceid) {
            checkNotNull(deviceid, "deviceid cannot be null");
            checkArgument(deviceid.length() > 0, "deviceid can't be an empty string");
            this.deviceid = deviceid;
            return this;
        }

        public FinalBuilder flowId(String flowid) {
            checkNotNull(flowid, "flowid cannot be null");
            checkArgument(flowid.length() > 0, "flowid can't be an empty string");
            this.flowid = flowid;
            return this;
        }

        public FinalBuilder baseMap(Map<String, String> baseMap) {
            checkNotNull(baseMap, "baseMap cannot be null");
            this.baseMap.putAll(baseMap);
            return this;
        }

        public FinalBuilder abcFlag(boolean abcFlag) {
            this.abcFlag = abcFlag;
            return this;
        }

        public FinalBuilder defFlag(boolean defFlag) {
            this.defFlag = defFlag;
            return this;
        }

        public FinalBuilder addTimeout(long timeout) {
            checkArgument(timeout > 0, "timeout must not be negative or zero");
            this.timeout = timeout;
            return this;
        }

        public RequestKey build() {
            return new RequestKey(this);
        }

    }
    public static Builder create() {
        return new Builder();
    }


    // getters here
}