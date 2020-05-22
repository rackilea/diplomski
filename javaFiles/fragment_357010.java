Integer maxKey = 
          map.entrySet()
             .stream() // create a Stream of the entries of the Map
             .max(Comparator.comparingInt(Map.Entry::getValue)) // find Entry with 
                                                                // max value
             .map(Map.Entry::getKey) // get corresponding key of that Entry
             .orElse (null); // return a default value in case the Map is empty