sample.package;
public static void main(String args[]) {
    StatelessKieSession ksession = [initialized KieSession]
    List<Command> cmds = new ArrayList<>();

    cmds.add([all required commands]);
    cmds.add(CommandFactory.newFireAllRules());
    cmds.add(CommandFactory.newGetObjects("facts"));
    ExecutionResults rulesResults = kSession.execute(CommandFactory.newBatchExecution(cmds));
    Collection<Object> results = (Collection<Object>) rulesResults.getValue("facts");
}