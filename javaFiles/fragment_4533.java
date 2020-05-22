int selected = 0;

for (int list1Index = 0, list2Index = 0;
     selected < count && (list1Index < list1.size() || list2Index < list2.size());
     selected++) {
    if (list1Index == list1.size()) {
        resultList2.add(list2.get(list2Index));
        list2Index++;
    } else if (list2Index == list2.size()) {
        resultList1.add(list1.get(list1Index));
        list1Index++;
    } else if (list1.get(list1Index).getDate() > list2.get(list2Index).getDate()) {
        resultList1.add(list1.get(list1Index));
        list1Index++;
    } else {
        resultList2.add(list2.get(list2Index));
        list2Index++;
    }
}