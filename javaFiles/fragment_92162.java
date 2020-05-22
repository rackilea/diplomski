if (bobmc.getName().equalsIgnoreCase("builders") && sender instanceof Player) {
            Player p = (Player) sender;
            String onlineBuilders = "";
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (PermissionsEx.getPermissionManager().getUser(players).inGroup("builder")) {
                    onlineBuilders += players.getName() + " ";
                }

            }

            sender.sendMessage(ChatColor.BLUE + "Builders List: " + ChatColor.BOLD + "" + onlineBuilders);
            return true;

        }