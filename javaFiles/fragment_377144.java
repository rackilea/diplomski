public List<String> customPrefixes(PermissionUser u)
  {
    List<String> returnlist = new ArrayList<String>();
    for (String k : u.getAllPermissions().keySet()) {
      List<String> perms = (List<String>)(u.getAllPermissions()).get(k);
      for (String s : perms) {
        String[] split = s.split(".");
        if ((split.length >= 3) &&
          (split[0].equalsIgnoreCase("plugin")) &&
          (split[1].equalsIgnoreCase("prefix"))) {
          returnlist.add(split[2]);
        }
      }

    }

    return returnlist;
  }