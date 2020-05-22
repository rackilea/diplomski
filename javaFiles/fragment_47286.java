private static ArrayList<ArrayList<ArrayList<Integer>>> getCopyThreeDimArrListPassByValue(ArrayList<ArrayList<ArrayList<Integer>>> origThreeDimArrList){
    ArrayList<ArrayList<ArrayList<Integer>>> copiedThreeDimArrList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> copiedArr;

    for (ArrayList<ArrayList<Integer>> origArr: origThreeDimArrList){
        copiedArr = new ArrayList<>(origArr.stream().map(x -> new ArrayList<>(x)).collect(Collectors.toList()));
        copiedThreeDimArrList.add(copiedArr);
    }

    return copiedThreeDimArrList;
}