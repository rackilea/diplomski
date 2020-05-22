public void removeZeros(ArrayList<Integer> list) {
    for (int j = 0; j < list.size(); j++) {
        if (list.get(j) == 0) {
            list.remove(j);
        }
    }
}