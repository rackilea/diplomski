DestinationSource ds = connection.getDestinationSource();
Set<ActiveMQQueue> queues = ds.getQueues();
// Add listener:
ds.setDestinationListener(event -> event.hashCode());
log.debug("Found '" + queues.size() + "' queues");
for (ActiveMQQueue queue : queues) {...}