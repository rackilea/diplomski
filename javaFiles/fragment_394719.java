public List<String> getCommandResults(String command) {
    FutureTask task = new FutureTask(new CommandTask(command))
    taskExecutor.execute(task);

    return task.get(); //or task.get(); return commandResults; - but it not a good practice
}