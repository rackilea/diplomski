public enum Command2 implements CommandI {

    FORWARD("qwersadd", new String[] { "fd", "forward" }),
    PENUP("vcvzxcvz", new String[] { "pu", "penup" });

    private final String description;
    private final String[] aliases;

    private Command2(String description, String[] aliases) {
        this.description = description;
        this.aliases = aliases;
    }

    @Override
    public boolean isCommand(String command) {
        for (String s : aliases) {
            if (s.equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execute(Drawer drawer, Creature creature) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getDescription() {
        return description;
    }

}