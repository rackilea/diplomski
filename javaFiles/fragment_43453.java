if (queueNames.contains(queue.getName()) && queue.isAutoDelete()
        && this.rabbitAdmin.getQueueProperties(queue.getName()) == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("At least one auto-delete queue is missing: " + queue.getName()
                                + "; redeclaring context exchanges, queues, bindings.");
            }
            this.rabbitAdmin.initialize();
            break;
}