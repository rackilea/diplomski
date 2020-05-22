public class Whatever extends JavaPlugin {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(command.getName().equalsIgnoreCase("hello")){
        sender.sendMessage("Hello!");
        return true;
    }
    return false;
  } 
}