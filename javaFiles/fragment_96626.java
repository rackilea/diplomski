public DefaultRemoteProxy(RegistrationRequest request, Registry registry) {
 super(request, registry);
 if (!(this instanceof Registrable)) {
  throw new UnsupportedOperationException("Cannot proceed further");
 }
 pollingInterval = config.nodePolling != null ? config.nodePolling : DEFAULT_POLLING_INTERVAL;
 unregisterDelay = config.unregisterIfStillDownAfter != null ? config.unregisterIfStillDownAfter : DEFAULT_UNREGISTER_DELAY;
 downPollingLimit = config.downPollingLimit != null ? config.downPollingLimit : DEFAULT_DOWN_POLLING_LIMIT;
}