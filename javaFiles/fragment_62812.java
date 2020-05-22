// below part of the code finds number occurrence count
for (Integer intNum : list) {
    if (!(hmap).containsKey(intNum)) {
        hmap.put(intNum, 1);
    } else {
        // below part to take care if a number comes twice i add 1
        // more(+1)
        hmap.put(intNum, list.get(intNum) + 1);
    }
    // Above part of the code finds number occurrence count
}