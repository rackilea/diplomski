static boolean allSingleDigit(ArrayList list) {
if (list.size() == 0)
    return true;
else {
    int first = (Integer) list.get(0);
    list.remove(0);

    if (first < 10)
        return allSingleDigit(list);
    else
        return false
}