if(!items.contains(args[0] + ",")){
                        getConfig().set(igitems + ".itemid", items + args[0] + ",");
                        saveConfig();
                        sender.sendMessage(prefix + ChatColor.GREEN + "Added " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " to ignore list.");
                    }  else {
                        sender.sendMessage(prefix + ChatColor.RED + "Item (" + ChatColor.GOLD + args[0] + ChatColor.RED + ") is already in the list !");
                    }