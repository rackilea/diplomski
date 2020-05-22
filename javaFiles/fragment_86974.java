while (true) {
        if (cashDesk.getLock().tryLock()) {
            try {
                cashDesk.serveClient(this);
            } catch (ResourceException e) {
                LOG.error("ResourceException!!! ", e);
            } finally {
                cashDesk.getLock().unlock();
                break;
            }
        } else {
            if (canChooseAnotherCashDesk()) {
                cashDesk.removeClient(this);
            }
        }
    }