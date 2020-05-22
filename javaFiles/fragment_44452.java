action(new AbstractTestAction() {
    @Override
    public void doExecute(TestContext context) {
        // do something with stored message
        Message message = context.getMessageStore().getMessage("operationResponse"); 
    }
})