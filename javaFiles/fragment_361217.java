public K getMaxKeyFromPos(EnumMap<K, List<T>> enumMap, int pos)
{
    K maxIndexKey = null;
    T maxIndexVal = null;

    for (K curKey : enumMap.keySet()) {
         T curVal = enumMap.get(curKey).get(pos);
         if (maxIndexVal == null || curVal.compareTo(maxIndexVal) > 0) {
             maxIndexVal = curVal;
             maxIndexKey = curKey;
         }
    }
    return maxIndexKey;
}