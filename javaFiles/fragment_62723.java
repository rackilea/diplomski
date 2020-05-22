public TopicEventListenerClient() {
        session = Diffusion.sessions().principal("admin").password("password").open("ws://localhost:8080");
        topicControl = session.feature(TopicControl.class);
        topicControl.addTopicEventListener("rabbitMQ/foo", new TopicEventListener() {

            @Override
            public void onClose(String arg0) {
                LOG.info("Listener closed");
            }

            @Override
            public void onError(String arg0, ErrorReason arg1) {
                LOG.info("Error on listener: " + arg1);
            }

            @Override
            public void onRegistered(String arg0, Registration arg1) {
                LOG.info("Listener registered");
            }

            @Override
            public void onHasSubscribers(String arg0) {
                LOG.info("Topic: " + arg0  + " has at least 1 subscriber");
            }

            @Override
            public void onNoSubscribers(String arg0) {
                LOG.info("Topic: " + arg0  + " has no subscribers");
            }
        });
    }