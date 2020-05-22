if(!userItem.equals(Material.AIR)){     
        user.getInventory().setHelmet(userItem);
        user.getInventory().setItemInHand(null);
    } else {
        user.sendMessage(ChatColor.RED+"Put an item in your hand");
    }