public void purge() {
        long createTime = System.currentTimeMillis() - timeToLive;
        for (Entry<String, Long> entry : appendersUsage.entrySet()) {
            if (entry.getValue() < createTime) {
                LOGGER.debug("Removing appender " + entry.getKey());
                appendersUsage.remove(entry.getKey());
                routingAppender.deleteAppender(entry.getKey());
            }
        }
    }