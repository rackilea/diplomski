Block block;
// ...
block.setType(Material.STANDING_BANNER);
Banner banner = (Banner)block.getState();
banner.setBaseColor(DyeColor.RED);
banner.update();