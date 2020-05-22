List<String> commandList = new ArrayList<String>(50);

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    //The ticket command
    if(cmd.getName().equalsIgnoreCase("ticket")){
        String ticket = "";
        // ommiting
        commandList.add(ticket);
        return true;
    } 
    else {
        return false;
    }
}