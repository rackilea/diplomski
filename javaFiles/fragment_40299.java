Player p = null;
String r = null;
String l = null;

for (int i = 1; i <= 3; i++) {
  String[] components = args[i].split(":");
  switch(components[0]) {
    case "u":
      p = player.getServer().getPlayer(components[1]);
      break;
    case "r":
      r = components[1];
      break;
    case "l":
      l = components[1];
  }
}

if (p != null && r != null && l != null) {
  Config.addPlayer(p, r, l, player);
  return true;
}