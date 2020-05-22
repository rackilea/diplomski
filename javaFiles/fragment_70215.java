public void addOverlay(Class<?> dataType) {
    Object subArray = Array.newInstance(dataType, mapSize);
    Object array = Array.newInstance(subArray.getClass(), mapSize);
    for (int i = 0; i < mapSize; i++) {
        Array.set(array, i, subArray);
    }
    overlayMap.add(array);
}