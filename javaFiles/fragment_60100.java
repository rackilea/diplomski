public void setMatrixArrayList(ArrayList<DoubleLinkedList<Integer>> matrixArrayList) {
for(int i = 0; i < matrixArrayList.size(); i ++){
    for (int j = 0; j < matrixArrayList.get(0).size(); j ++) {
        this.rowItemList.add(matrixArrayList.get(0).get(j));
    }
    this.matrixArrayList.add(this.rowItemList.clone());
    this.rowItemList.clear();
}
}