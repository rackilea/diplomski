v = toExplore.peek();
for (int u: getAdjList(v).keySet())
{
   if (!visited.contains(u))
   {
      ...
   }
}