public List<String> getData(int[][] res) {
    ArrayList<String> resStrings = new ArrayList<>();        
    for (int[] i : res) {
          for (int j : i) {
              resStrings.add(getString(j));
          }
    }
    return resStrings;
 }