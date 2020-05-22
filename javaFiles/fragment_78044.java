int size1 = dimList1.size();
int size2 = dimList2.size();
int maxSize = Math.max(size1, size2);
if (size1 < maxSize) {
    fillZeros(dimList1, maxSize);
} else {
    fillZeros(dimList2, maxSize);
}


private void fillZeros(ArrayList<Double> list, int maxSize) {
    for(int i = list.size(); i < maxSize; i++) {
        list.add(0.0D);
    }
}