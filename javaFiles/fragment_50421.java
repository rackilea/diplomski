RegionContainer container = getWorldGuard().getRegionContainer();
RegionManager regions = container.get(player.getWorld());
if(regions != null){
  ProtectedRegion region = regions.getRegion(sign.getLine(3));
  DefaultDomain owners = region.getOwners();
if(owners.contains(player.getUniqueId())){