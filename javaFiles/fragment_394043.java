class CommandSession {
    private List<Command> commands = new ArrayList<>();
    private ListIterator<Command> scroller;

    public void execute(Command command) {
        scroller = null;
        commands.add(command);
        command.execute();
    }

    public Command scrollUp() {
        if (scroller == null) {
            scroller = commands.listIterator(commands.size());
        }
        if (scroller.hasPrevious()) {
            return scroller.previous();
        }
        return null;
    }
}