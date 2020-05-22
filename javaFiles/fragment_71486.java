public String callMethod(String name) {
    Command command = commands.get(name);
    if(command != null) {
        command.execute();
    }
}