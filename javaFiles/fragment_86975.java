while (true) {
        if(cashDesk.current==null)
             cashDesk.nextClient();
        if (current==this) {
            try {
                cashDesk.serveClient(this);
            } catch (ResourceException e) {
                LOG.error("ResourceException!!! ", e);
            } finally {
                cashDesk.nextClient();
                break;
            }
        } else {
            if (canChooseAnotherCashDesk()) {
                cashDesk.removeClient(this);
            }
        }
    }