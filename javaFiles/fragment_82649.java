private Location dfs(Set<Location> visitedAlready,Location current, Integer id){
   if(current.id == id)
      return current;
   visitedAlready.add(current); // instead of your boolean
   Location result = null;
   for(Location l : current.locations) {
      result = dfs(visitedAlready,l,id);
      if(result != null)
        break;
   }
   return result;
}