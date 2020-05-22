Destination management = session.createTopic(ScheduledMessage.AMQ_SCHEDULER_MANAGEMENT_DESTINATION);
MessageProducer mproducer = session.createProducer(destination);
Message request = session.createMessage();
request.setStringProperty(ScheduledMessage.AMQ_SCHEDULER_ACTION,
        ScheduledMessage.AMQ_SCHEDULER_ACTION_REMOVEALL);
mproducer.send(request);