Map<String, Command> commands = new HashMap<String, Command>();
commands.put("myCommand1", new MyCommand());
commands.put("myCommandN", new MyCommandN());

JCommander cmd = new JCommander();
cmd.addCommand("myCommand1", cmd1);
...
cmd.addCommand("myCommandN", cmdN);
try {
    cmd.parse(args);

    Command command = commands.get(cmd.getParsedCommand());
    if(command == null){
       cmd.usage();
    }
    // execute command
}
 ...