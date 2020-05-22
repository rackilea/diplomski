public class MyCommandExecutor implements CommandExecutor {
    private final Whatever plugin;

    public MyPluginCommandExecutor(Whatever plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("test")){
            sender.sendMessage("Hello World!");
            return true;
        }
        return false;
    }
}