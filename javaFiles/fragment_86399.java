NativeArray arr = (NativeArray) result;
Object [] array = new Object[(int) arr.getLength()];
for (Object o : arr.getIds()) {
    int index = (Integer) o;
    array[index] = arr.get(index, null);
}