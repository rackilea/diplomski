@Override
public void handleError(Throwable t) {
  log.warn("Execution of Rabbit message listener failed.", t);

  try {
    queueForExponentialRetry(((ListenerExecutionFailedException) t).getFailedMessage());
  } catch (RuntimeException ex) {
    t.addSuppressed(ex);
    log.error("Not requeueing after failure", t);
    throw new AmqpRejectAndDontRequeueException(t);
  }

  throw new ImmediateAcknowledgeAmqpException("Queued for retry");
}