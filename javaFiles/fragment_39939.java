Map whatEverThisIs = (Map)getWorlds();
if (whatEverThisIs == null) {
   /* Do something here */
}
Map worlds = (Map)whatEverThisIs.get("Worlds");
if (worlds == null) {
   /* Do something here */
}
Map worldMap = (Map)worlds.get(String.valueOf(world));
if (worldMap == null) {
   /* Do something here */
}
Map levels = (Map)worldMap.get("Levels");
if (levels == null) {
   /* Do something here */
}