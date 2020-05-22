//Overrides bukkits onCommand with modified code
@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (args.length > 1) {//No more then 1 argument
        sender.sendMessage("[ConsoleFilter] Too many arguments!"); //Sends player a message
        return false;
    } 
    if (args.length < 1) {//No less then 1 argument
        sender.sendMessage("[ConsoleFilter] Not enough arguments!"); //Sends player a message
        return false;
    }
    //plugin.yml will actually validate permissions, however additional provisions allows for 
    //further security and further extendability.
    if (sender instanceof Player){ //if sender is a player entity
        Player player = (Player) sender; //Sets player to sender
        if (player.isOp() || player.hasPermission("ConsoleFilter.Reload")){//Is the player an Op or have specified Permission
            if (cmd.getName().equalsIgnoreCase("CF")) { //Checks for /CF
                if (args[0].equalsIgnoreCase("Reload")){ //Checks for /CF Reload
                    this.reloadConfig(); //Reloads config file back into memory
                    player.sendMessage(ChatColor.DARK_GREEN + "Config Reloaded!"); //Sends player a message
                    getLogger().info("[ConsoleFilter] Config Reloaded");
                    return true; //Close True
                }
            }
        }else{
            player.sendMessage("You do not have the appropriate Permissions. (ConsoleFilter.Reload)");;
        }
    }else{
        this.reloadConfig(); //Reloads config file back into memory
        getLogger().info("[ConsoleFilter] Config Reloaded");
        return true; //Close True
    }
    return false;
}