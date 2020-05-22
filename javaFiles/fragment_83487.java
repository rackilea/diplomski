public void printNodes(String[] nameList){

    int j;
    for (j = 0; j < nameList.length; j++){
        addNode(front, nameList[j]);
    }  showList(front);
}