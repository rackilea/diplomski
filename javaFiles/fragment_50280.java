ArrayList<ArrayList<Integer>> dataArrays = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> dataList = new ArrayList<Integer>();

dataList.add(4);
dataList.add(44);
dataList.add(444);
dataArrays.add(dataList);

dataList = new ArrayList<Integer>();
dataList.add(1);
dataList.add(11);
dataList.add(111);
dataArrays.add(dataList);

Collections.sort(dataArrays, new Comparator<ArrayList<Integer>>() {
    public int compare(ArrayList<Integer> arg0, ArrayList<Integer> arg1) {
        return arg0.get(0).compareTo(arg1.get(0));
    }
});

System.out.println(dataArrays);