public ArrayList<HashMap<String,Integer>> makeAlist(HashMap<String,Integer> Values1, HashMap<String, Integer> Values2, HashMap<String, Integer> Values3,
HashMap<String, Integer> Values4, HashMap <String, Integer> Values5, HashMap<String, Integer> Values6){

ArrayList<HashMap<String,Integer>> mergedCategories = new ArrayList<>();

    mergedCategories.add(Values1);
    mergedCategories.add(Values2);
    mergedCategories.add(Values3);
    mergedCategories.add(Values4);
    mergedCategories.add(Values5);
    mergedCategories.add(Values6);

    return mergedCategories;
}