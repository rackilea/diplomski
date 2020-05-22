try {
            // use the end user configured poll timeout
            exchange = queue.poll(pollTimeout, TimeUnit.MILLISECONDS);
            // Omitted
        } catch (InterruptedException e) {
            LOG.debug("Sleep interrupted, are we stopping? {}", isStopping() || isStopped());
            continue;
        } catch (Throwable e) {
            if (exchange != null) {
                getExceptionHandler().handleException("Error processing exchange", exchange, e);
            } else {
                getExceptionHandler().handleException(e);
            }
        }