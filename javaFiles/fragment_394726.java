public int getIndexOfMaxValue(final List<Integer> list)
{
    int maxFound = Integer.MIN_VALUE, value;
    int ret = 0;

    for (int index = 0; index < list.size(); index++) {
        value = list.get(index);
        if (value > maxFound) {
            maxFound = value;
            ret = index;
        }
    }

    return ret;
}