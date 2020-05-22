public Location find(Integer locationId) {
   Location result = null;
   for(Location l : locations) {
      // this hashset represents the visited state which only matters for this method call
      result = dfs(new HashSet(),l,locationId); 
      if(result != null)
          break;
   }
   return result;
}