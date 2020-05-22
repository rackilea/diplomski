@Override
    public State onStatusReceived(HttpResponseStatus responseStatus) throws Exception {
        Integer status = responseStatus.getStatusCode();
        if (304 == status) {  // CONDITIONAL FINISH THIS CALL
            return State.ABORT;
        } else {
            doSomething()
            return ...
        }           
    }