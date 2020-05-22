public List<String> getData(int[] res) {
    ArrayList<String> resStrings = new ArrayList<>();
    for (int i : res) {
          resStrings.add(getString(i));
    }
    return resStrings;
 }