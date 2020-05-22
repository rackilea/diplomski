List<Location> locationss = pasteSchematic(mySchematicFile);
for(Location loc : locations){
 if(loc.getBlock().getType().equals(Material.BEACON)){
  //a beacon was plasted at the loc
 }
}