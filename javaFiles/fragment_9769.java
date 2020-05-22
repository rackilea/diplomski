public int indexOf(String subString, int start) {
    if (start < 0) start = 0;
    int subCount = subString.count;
    if (subCount > 0) {
        if (subCount + start > count) return -1;
        char[] target = subString.value;
        int subOffset = subString.offset;
        char firstChar = target[subOffset];
        int end = subOffset + subCount;
        while (true) {
            int i = indexOf(firstChar, start);
            if (i == -1 || subCount + i > count) return -1; // handles subCount > count || start >= count
            int o1 = offset + i, o2 = subOffset;
            while (++o2 < end && value[++o1] == target[o2]);
            if (o2 == end) return i;
            start = i + 1;
        }
    } else return start < count ? start : count;
}