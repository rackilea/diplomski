private Location getLocation(World world, String beaconPrefix) {
  double x = getConfig().getDouble(beaconPrefix + ".x");
  double y = getConfig().getDouble(beaconPrefix + ".y");
  double z = getConfig().getDouble(beaconPrefix + ".z");
  return new Location(world, x, y, z);
}