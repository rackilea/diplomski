if (args == null) {
    p.sendMessage(ChatColor.RED + "You must use an arg!");
    return false;
}

if (args[0].equals("0") {
    p.setGameMode(GameMode.SURVIVAL);
    p.sendMessage(ChatColor.RED + "Gamemode set to survival");
    return true;
} else if (args[0].equals("1") {
    //Setgamemode to creative
    //......
}