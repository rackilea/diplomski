Exchange ex = endpoint.createExchange(ExchangePattern.InOnly);
setMyMessageHeaders(ex.getIn(), myMessagemetaData);
setMyMessageBody(ex.getIn(), myMessage);

getAsyncProcessor().process(ex, new AsyncCallback() {
    @Override
    public void done(boolean doneSync) {
        LOG.debug("Mssage was processed " + (doneSync ? "synchronously" : "asynchronously"));
    }
});