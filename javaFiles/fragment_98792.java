List<Command> cmds = new ArrayList<>();
    cmds.add(CommandFactory.newInsert(req, "request"));
    cmds.add(CommandFactory.newFireAllRules());
    cmds.add(CommandFactory.newGetObjects(new ClassObjectFilter(Validation.class), "validations"));
    ExecutionResults results = kSession.execute(CommandFactory.newBatchExecution(cmds));
    Collection<?> validations = (Collection<?>) results.getValue("validations");