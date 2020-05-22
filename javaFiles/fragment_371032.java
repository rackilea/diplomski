if(label.equalsIgnoreCase("baltop")){
    if(!(sender instanceof Player)){
        CommandUtils.invalidCommandSender(sender);
        return true;
    }
    TreeSet<Balance> set = new TreeSet<>();
    set = set.descendingSet();
    File[] files = new File(ServerCore.getPlugin().getDataFolder(), File.separator + "PlayerData").listFiles();
    for (File file : files){
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(file);
        double bal = playerData.getDouble("Money");
        UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));
        set.add(new Balance( Bukkit.getOfflinePlayer(uuid).getName(), uuid, bal));
    }

    for (Balance b : set) {
        ChatUtils.sendRawMessage(sender, b.name + ": " + b.balance);
    }
    return true;
}

private static class Balance implements Comparable<Balance> {
    public String name;
    public UUID uuid;
    public double balance;
    public Balance(String n, UUID u, double b) {
        name = n;
        uuid = u;
        balance = b;
    }
    @Override
    public int compareTo(Balance b) {
        double d = balance - b.balance;
        if (d<-0.001||d>0.001)
            return (int) Math.signum(d);

        int e = -name.compareToIgnoreCase(b.name);
        if (e != 0)
            return e;
        return -uuid.compareTo(b.uuid);
    }
}