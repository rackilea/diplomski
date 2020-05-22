/* (BlockBreakEvent event) */ {
    Location brokenBlock = event.getBlock().getLocation();

    for (int i = 1; i < 16; i++)
        brokenBlock.add(0, i, 0).getBlock().breakNaturally();
}