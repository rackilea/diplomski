int n = shortest.size();
  for (int k = 0; k < n; k++) { 
    for (int i = 0; i < n; i++) { 
      for (int j = 0; j < n; j++) { 
        shortest.get(i).set(j,
            Math.min(shortest.get(i).get(k) + shortest.get(k).get(j), 
                     shortest.get(i).get(j)));
      } 
    } 
  }