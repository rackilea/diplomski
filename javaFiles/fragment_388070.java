public void function(){
    int [] dataSet = {1,2,3,4,5,6,7,8,9,10};
    ArrayList<ArrayList <int> > result = new ArrayList<>();

    for(int i = 0;i<dataSet.length;i++){
        for(int j = 0;j<dataSet.length;j++){
            if(i == j)
                continue;
            ArrayList<int> tmp = new ArrayList<>();
            tmp.add(dataSet[i]);
            tmp.add(dataSet[j]);
            result.add(tmp);
        }
    }
}