for(map.entry<String,ArrayList<Integer>> y:hk.getentryset()){
    List<Integer> allScores;
    if(hp.get(y.getKey())==null){
        allScores = new ArrayList<>();
        hp.put(key, allScores);
    }
    else{
        allScores = hp.get(y.getKey());
    }
    allScores.addAll(y.getvalue());
}