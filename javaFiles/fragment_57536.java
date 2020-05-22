if (args.length < 1) {

            sender.sendMessage("§cUsage: /msg <player> <msg>");
            return true;
        }
Player target = Bukkit.getServer().getPlayer(args[0]);

    if (cmd.getName().equalsIgnoreCase("msg")) {

        if (target != null) {

            if (args.length > 1) {

                String msg = "";

                for (int i = 1; i < args.length; i++){
                    String arg = (args[i] + " ");
                    msg = (msg + arg);
                }

                target.sendMessage("§b(From§f " + sender.getName() + "§b)§f " + msg);
                sender.sendMessage("§b(To§f " + target.getName() + "§b)§f " + msg);
                return true;
            }
        }

        if (target == null) {

            sender.sendMessage("§cThat player is offline.");
            return true;