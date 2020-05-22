if(!userItem.equals(Material.AIR)){     
        user.getInventory().setHelmet(userItem);
        ItemStack a = new ItemStack(Material.AIR, 1); // Error happens here
        user.getInventory().setItemInHand(a);
    } else {
        user.sendMessage(ChatColor.RED+"Put an item in your hand");
    }