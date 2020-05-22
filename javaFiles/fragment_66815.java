public static ArrayList<Integer> maxIndices(ArrayList<Integer> list) {
    List<Integer> indices = new ArrayList<Integer>();
    int max =  getMaxValue(list);
    for (int i = 0; i < list.size(); i++) {
       if(list.get(i) == max) {
           indices.add(list.get(i));
        }
     }

     return indices;
}