int index = myIndexOf(benefit, find);

...

static int myIndexOf(List<HashMap> benefit, Map find) {
    int i = 0;
    for (Map map : benefit) {
        Map tmp = new HashMap(map);
        tmp.keySet().retainAll(find.keySet());
        if (tmp.equals(find)) {
            return i;
        }
        i++;
    }
    return -1;
}