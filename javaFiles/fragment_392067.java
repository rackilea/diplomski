ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("failover:(tcp://host1:5670)");
    cf.setTransportListener(new TransportListener() {
        @Override
        public void transportResumed() {
        }

        @Override
        public void transportInterupted() {
        }

        @Override
        public void onException(IOException error) {
        }

        @Override
        public void onCommand(Object command) {
        }
    });