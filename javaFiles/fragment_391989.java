private static void addOldMapping() {
      for (String[] arrayOfString1 : oldMappings) {
        aliases.put(arrayOfString1[0], arrayOfString1[1]);
      }
      if (USE_OLDMAPPING) {
        aliases.put("EST", "America/New_York");
        aliases.put("MST", "America/Denver");
        aliases.put("HST", "Pacific/Honolulu");
      } else {
        zones.put("EST", new ZoneInfo("EST", -18000000));
        zones.put("MST", new ZoneInfo("MST", -25200000));
        zones.put("HST", new ZoneInfo("HST", -36000000));
      }
}