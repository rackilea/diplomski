arraylist source (cat, dog, vehicle)
arraylist prefix (c, do, vi)
Method: Pass in two arraylists source and prefix
arraylist mergedlist, unusedPrefixes
for (int x - prefix) //loop through prefix list
  bool used = false;
  for (int y - source) //loop through source list
    if source startsWith prefix
      add that source item to merged list
      used = true;
  if !used
    add prefix to unusedPrefixes
add unusedPrefixes to mergedList