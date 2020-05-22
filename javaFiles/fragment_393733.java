static final Map<String, Command> COMMANDS = new HashMap<>(8);

static {
   COMMANDS.put("join", new JoinCommand());
   COMMANDS.put("leave", new LeaveCommand());
   // And so on
}