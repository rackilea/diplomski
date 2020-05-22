public void processData()  {
    List<Info> infoList = new ArrayList<>();
    List<Info> infoListFiltered = new ArrayList<>();
    infoList.add(new Info("a",1, 2));
    infoList.add(new Info("b",2, 2));
    infoList.add(new Info("c",1, 3));
    infoList.add(new Info("d",1, 2));
    infoList.add(new Info("e",1, 2));
    for (Info info:infoList){
        int index=getDuplicateIndex(infoListFiltered,info);
        if(index==-1){
            infoListFiltered.add(info);
        }else{
            infoListFiltered.get(index).name+=","+info.name;
        }
    }
}

private int getDuplicateIndex(List<Info> infoListFiltered,Info info){
    for (int i = 0; i < infoListFiltered.size(); i++){
        if(infoListFiltered.get(i).height==info.height && infoListFiltered.get(i).weight==info.weight){
            return i;
        }
    }
    return -1;
}