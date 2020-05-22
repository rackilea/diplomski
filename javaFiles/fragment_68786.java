Location loc = player.getLocation();
loc.setX(event.getBlockClicked().getX());
loc.setZ(event.getBlockClicked().getZ());
loc.setY(event.getBlockClicked().getY());
World world = loc.getWorld();

Sign sign = (Sign)world.getTileEntity(world.getBlockAt(loc));