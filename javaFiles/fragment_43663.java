ArrayList<String> temp = new ArrayList<String>();
boolean found = false;
for (int i = 0; i < arrList1.size(); i++) {
    found = false;
    for (int j = 0; j < arrList2.size(); j++) {
        if (arrList1.get(i).equals(arrList2.get(j))) {
            found = true;
            if (!temp.contains(arrList2.get(j)) {
                arrList4.add(arrList2.get(j));
            }
        }
    }
    if (found) {
        arrList3.add(arrList1.get(i));
        temp.add(arrList1.get(i));
    }
}