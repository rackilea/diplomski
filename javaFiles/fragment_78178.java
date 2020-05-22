boolean matches = true;

for (JsonNode nodeB : arrayB)
{
   boolean matchesInternal = false;

   for (JsonNode nodeA : arrayA)
   {
      if (nodeA.equals(nodeB))
      {
          matchesInternal = true;
          break;
      }
   }

   if (!matchesInternal) {
      matches = false;
      break;
   }
}

return matches;