try (ModelControllerClient client = ModelControllerClient.Factory.create("localhost", 9990)) {
    final ModelNode address = Operations.createAddress("subsystem", "logging");
    final ModelNode op = Operations.createOperation(ClientConstants.READ_CHILDREN_NAMES_OPERATION, address);
    op.get(ClientConstants.CHILD_TYPE).set("logger");
    final ModelNode result = client.execute(op);
    if (Operations.isSuccessfulOutcome(result)) {
        final List<ModelNode> loggerNames = Operations.readResult(result).asList();
        for (ModelNode loggerName : loggerNames) {
            System.out.printf("logger=%s%n", loggerName.asString());
        }
    } else {
        System.err.printf("Failed to get the logger names: %s%n", Operations.getFailureDescription(result).asString());
    }
}