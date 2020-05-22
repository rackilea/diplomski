static Object[] getBackingArray(ArrayList<?> arrayList) {
    try {
        Field elementData = ArrayList.class.getDeclaredField("elementData");
        elementData.setAccessible(true);
        return (Object[]) elementData.get(arrayList);
    } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}